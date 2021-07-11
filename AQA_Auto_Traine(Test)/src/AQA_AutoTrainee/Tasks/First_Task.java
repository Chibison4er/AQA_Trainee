package AQA_AutoTrainee.Tasks;

import java.util.Scanner;

import AQA_AutoTrainee.Main;

public class First_Task implements ITask
{
	protected String taskNumber = "№1 - %s";
	protected String task = "Введите число: ";
	
	private int digit = 7;
	protected String msg = "Привет.";
	
	private Scanner input;
	
	@Override
	public void inputData() 
	{
		input = new Scanner(System.in);
		
		if(input.hasNext())
		{
			String line = input.next();
			
			if(line.length() != 0)
			{
				int parsedDigit;
				
				try
				{
					parsedDigit = Integer.parseInt(line);
					
					if(parsedDigit > digit)
					{
						Main.showText(msg);
						Main.waitUser();
					}
					
				}catch(NumberFormatException e)
				{
					Main.showText("[INPUT_ERROR] Ошибка ввода \"Отсутствуют цифры\" попробуйте еще раз");
					Main.openTask(1);
				}
			}else
			{
				Main.showText("[INPUT_ERROR] Ошибка ввода \"Пустые данные\" попробуйте еще раз");
				Main.openTask(1);
			}
		}
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
