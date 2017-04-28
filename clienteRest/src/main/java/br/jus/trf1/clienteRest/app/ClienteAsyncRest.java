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
	private static int quantCompletas = 1;
	private static int quantFalhas = 1;

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 800; i++) {
			request();
			Thread.sleep(new Random().nextInt(94));
		}
		
		
		System.out.println("Passou");
		

	}

	private static void request() {
		final Client client = ClientBuilder.newClient();
		final WebTarget target = client.target("http://localhost:8080/arquitetura/rest/async/funcionario/2");
		future = target.request().async().get(new InvocationCallback<Funcionario>() {

			public void completed(final Funcionario arg0) {
				System.out.println( LocalDateTime.now()+" - Completo "+ Thread.currentThread().getName());
			      // target.request().async().get(this);
				client.close();
				System.out.println("Quantidade Completas: "+quantCompletas++);
				
			}

			public void failed(final Throwable arg0) {
				// TODO Auto-generated method stub
				System.out.println(LocalDateTime.now()+" - falha "+ Thread.currentThread().getName());
				arg0.printStackTrace();
				client.close();
				System.out.println("Quantidade Falhas: "+quantFalhas++);
			}
			
		});
	}
}
