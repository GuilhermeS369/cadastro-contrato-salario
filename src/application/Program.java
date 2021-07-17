package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
			
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//FORMATAÇÃO PARA DATA
				
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.print("Enter worker data: ");
		sc.nextLine();
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
				
			Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
//INSTANCIADO UM OBJETO DO TIPO WORKER, JA SUBINDO  O COSNTRUTOR COM NOME DO TRABALHADOR, O WORKER LEVEL COM VALUE OF PRA TRASNFORMAR
//STRING NUM TIPO ENUM, O BASE SALARY, EAI O CONSTRUTOR DEPARTAMENTO JÁ PRA DEFINIR O DEPARTAMENTO ENTREGAR PRO CONSTRUTOR O DEPARTAMENTO
			
			System.out.print("How many contracts to this worker?");
			
			int n = sc.nextInt();
			
			for (int i = 1 ;i<n ; i++) {//CRIAR E PERCORRER ALISTA
				System.out.println("Enter contract#" + i + "data:");
				System.out.print("Date DD/MM/YYYY");
				Date contractDate = sdf.parse(sc.next()); //ARMAZENA A DATA COM A FORMATAÇÃO DECLARA NO COMEÇO DO CODIGO
				System.out.print("Value per hour");
				double ValuePerHour = sc.nextDouble();
				System.out.println("Duration(hours): ");
				int hours = sc.nextInt();
				HourContract contract = new HourContract(contractDate, ValuePerHour, hours);//INSTANCIEI UM NOVO CONTRATO
				worker.addContract(contract);//ADICIONEI ESSE CONTRATO A LISTA, LISTA DECLARADA NO WORKER			
			}
			
			System.out.println();
			System.out.print("Enter month and year to calculate income (MM/YYYY): ");
			String monthAndYear = sc.next();//VARIAVEL Q VAI RECEBER A DATA
			int month = Integer.parseInt(monthAndYear.substring(0, 2));
			//RECORTAR A STRING COMEÇA NO PONTO ZERO E VAI ATÉ O PONTO 2 PENDO OS DIAS
			//TRANSFORMANDO O CONTEUDO SALVO EM VARIAVEL DO TIPO INTEIRO
			int year = Integer.parseInt(monthAndYear.substring(3));
			//RECORTAR A STRING PARTIR DO TERCEIRO CARACTER Q É O FIM DO ANO
			//TRANSFORMANDO O CONTEUDO SALVO EM VARIAVEL DO TIPO INTEIRO
			
			System.out.println("Name:" + worker.getName());
			System.out.println("Department: " + worker.getDepartment().getName());
			//AQUI CHAMAMOS O TIPO DEPARTAMENTO DA CLASSE WORKER, EAI O GET NAME PRA DENTRO DO TIPO DERPARTAMENTO.
			System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
			
		sc.close();
		
	}

}
