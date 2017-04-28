package br.jus.trf1.clienteRest.app;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;

import br.jus.trf1.pocArquitetura.entidades.Funcionario;

public class ClienteAsyncRest {

	private static Future future;

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 50; i++) {
			request();
			Thread.sleep(new Random().nextInt(2000/50));
		}
		
		
		System.out.println("Passou");
		

	}

	private static void request() {
		Client client = ClientBuilder.newClient();
		final WebTarget target = client.target("http://localhost:8080/arquitetura/rest/async/funcionario/2");
		future = target.request().async().get(new InvocationCallback<Funcionario>() {

			@Override
			public void completed(final Funcionario arg0) {
				System.out.println( LocalDateTime.now()+" - Completo "+ Thread.currentThread().getName());
			      // target.request().async().get(this);
				client.close();
				
			}

			@Override
			public void failed(final Throwable arg0) {
				// TODO Auto-generated method stub
				System.out.println(LocalDateTime.now()+" - falha "+ Thread.currentThread().getName());
				arg0.printStackTrace();
				client.close();
			}
			
		});
	}
}
