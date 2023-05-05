package control;

import java.util.Scanner;

import model.Fila;

public class SenhaController {
		Scanner input = new Scanner(System.in);
		Fila fila;
		Fila filaP;
		private static int id = 0;
		private static int senha = 1;
		private static int senhaP = 1;
		
	public SenhaController(Fila fila, Fila filaP) {
		this.fila = fila;
		this.filaP = filaP;
	}
	
	public void addSenha() {
		int escolha = 0;
		while(escolha!=9) {
			System.out.println("1 - adicionar fila normal\n2 - adicionar fila prioritaria\n9 - voltar");			
			escolha = input.nextInt();
			switch(escolha) {
				case 1: fila.insert(senha);
					System.out.println(senha+" foi adicionado");
					senha++;
				break;
				case 2: fila.insert(senhaP);
					System.out.println(senhaP+"(prioritario) foi adicionado");
					senhaP++;
				break;
				case 9: System.out.println("voltar");
				break;
				default : System.out.println("opcao invalida");
				break;
			}
		}
	}
	
	public void callSenha(){
		try {
			if(!filaP.isEmpty()) {
				id++;
				if(id%4==0) {
					System.out.println(fila.remove()+" foi chamado");
				}else {
					System.out.println(filaP.remove()+"(prioritario) foi chamado");
				}
			}else {
				if(!fila.isEmpty()) {
					System.out.println(fila.remove()+" foi chamado");
				}else {
					System.out.println("Filas vazias, chamar mais senhas");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}