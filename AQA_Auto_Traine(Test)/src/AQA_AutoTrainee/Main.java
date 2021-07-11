package AQA_AutoTrainee;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import AQA_AutoTrainee.Tasks.First_Task;
import AQA_AutoTrainee.Tasks.ITask;
import AQA_AutoTrainee.Tasks.Second_Task;
import AQA_AutoTrainee.Tasks.Third_Task;

public class Main 
{	
	private static boolean isAuthorWasShow = false;
	private static Scanner input;
	
	private static ITask userChoose;
	
	public static void main(String... args)
	{
		input = new Scanner(System.in);
		
		showTasksList();
	}
	
	private static void showTasksList()
	{
		if(!isAuthorWasShow)
		{
			isAuthorWasShow = true;
			
			showText("Полищук Максим \"Java\"\n");

		}
		
		showText(new First_Task().toString());
		showText(new Second_Task().toString());
		showText(new Third_Task().toString());
		
		showText("\nВыберите одно из заданий и впишите в консоль номер задания....");
		
		int taskNumber;
		
		try
		{
			String line = "";
			
			if(input.hasNext())
			{
				line = input.nextLine().trim();
				
				if(line.length() > 1)
				{
					showText("[Ваш ответ не число!]");
					showTasksList();
				}else
				{
					taskNumber = Integer.parseInt(line);
					
					if(taskNumber > 3 || taskNumber < 1)
					{
						showText(String.format("[Задание с номером %s ненайдено]", taskNumber));
						showTasksList();
					}
					
					openTask(taskNumber);
				}
			}
		}catch(NumberFormatException e)
		{
			showText("[Ваш ответ не число!]");
			showTasksList();
		}
	}
	
	public static void openTask(int taskNumber)
	{
		boolean isAlreadyShow = false;
		
		if(userChoose != null)
		{
			showText(userChoose.toString());
			
			isAlreadyShow = true;
		}
		
		switch(taskNumber)
		{
			case 1:
			{
				userChoose = new First_Task();
				
				if(!isAlreadyShow)
					showText(userChoose.toString());

				userChoose.inputData();
				
				break;
			}
			case 2:
			{
				userChoose = new Second_Task();
				
				if(!isAlreadyShow)
					showText(userChoose.toString());
				
				userChoose.inputData();

				break;
			}
			case 3:
			{
				userChoose = new Third_Task();
				
				if(!isAlreadyShow)
					showText(userChoose.toString());
				
				userChoose.inputData();
				
				break;
			}
		}
	} 
	
	public static void showText(String text) { System.out.println(text); }
	public static void waitUser()
	{
		if(input.nextLine().length() >= 0)
		{
			System.exit(0);
		}
			
	}
}