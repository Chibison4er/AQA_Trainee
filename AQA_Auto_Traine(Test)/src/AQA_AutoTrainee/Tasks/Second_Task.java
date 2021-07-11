package AQA_AutoTrainee.Tasks;

import java.util.Scanner;

import AQA_AutoTrainee.Main;

public class Second_Task implements ITask
{
	protected String taskNumber = "№2 - %s";
	protected String task = "Введите имя: ";
	
	private String checkedName = "Вячеслав";
	private Scanner input;
	
	@Override
	public void inputData() 
	{
		String line = "";
		
		input = new Scanner(System.in);
		
		if(input.hasNext())
		{
			line = input.next();
			
			if(line.length() > 0)
			{
				if(line.equalsIgnoreCase(checkedName))
					Main.showText(String.format("Привет, %s", checkedName));
				else
					Main.showText("Нет такого имени");
				
				Main.waitUser();
			}else
			{
				Main.showText("[INPUT_ERROR] Строка на входе была пустой, попробуйте еще раз");
				Main.openTask(2);
			}
		}else
		{
			Main.showText("[INPUT_ERROR] Строка на входе была пустой, попробуйте еще раз");
			Main.openTask(2);
		}
		
		input.close();
	}
	
	@Override
	public String getTaskNumber() {
		return taskNumber;
	}
	
	@Override
	public String getTask() {
		return task;
	}
	
	@Override
	public String toString() { return String.format(taskNumber, task); }
}
