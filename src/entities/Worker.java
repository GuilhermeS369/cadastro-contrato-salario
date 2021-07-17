package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level; //VARIAVEL DO TIPO WORKER
	private Double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	//INSTANCIADO A LISTA DO TIPO CONTRATO
	
	
	
	public Worker() {
		}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public WorkerLevel getLevel() {
		return level;
	}
	
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	
	public Double getBaseSalary() {
		return baseSalary;
	}
	
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract (HourContract contract) {
		contracts.add(contract);		
	}
	
	public void removeContract (HourContract contract) {
			contracts.add(contract);
	}
	public double income(int year, int month) { // FUNCAO RECEBE SOMA 
		double sum = baseSalary; //AGREGUEI O SALARIO
		Calendar cal = Calendar.getInstance();//INSTANCIEI O CALENDARIO
		for(HourContract c : contracts) { //PERCORRI A LISTA
			cal.setTime(c.getDate()); //PEGUEI A DATA DO CONTRATO E DEFINI NO CALENDARIO
			
			int c_year = cal.get(Calendar.YEAR) ;//PUXEI O ANO EM UMA VARIAVEL
			
			int c_month = 1 + cal.get(Calendar.MONTH);//PUXEI O MES EM UMA VARIAVEL
			
			if (year == c_year && month == c_month) { // SE O ITEM DA LISTA TIVER O ANO E O MES
													// IGUAL AO INFORMADO, ELE SOMA NA VARIAVEL
				
				sum += c.totalValue(); //O CODIGO DE SOMAR O VALOR TOTAL DE CADA CONTRATO
			}
		}
		return sum; //RETORNAR A SOMA PARA O INCOME
			
	}
	
	
	
	
}
