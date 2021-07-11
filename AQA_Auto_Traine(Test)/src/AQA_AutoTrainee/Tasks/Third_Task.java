package AQA_AutoTrainee.Tasks;

import java.util.Scanner;

import AQA_AutoTrainee.Main;

public class Third_Task implements ITask
{
	protected String taskNumber = "�3 - %s";
	protected String task = "������� ������ �������� ����� ������\n������ [1 2 3 4...]\nP.S. -=��� ������=-";
		
	private Scanner input;
	
	@Override
	public void inputData() 
	{
		input = new Scanner(System.in);
		String errorArg = "";
		
		String result = "";
		
		if(input.hasNext())
		{
			String[] args = input.nextLine().split(" ");
			
			if(args.length > 0)
			{
				int digit;
				
				try
				{
					for(String charNum : args)
					{
						errorArg = charNum;
						digit = Integer.parseInt(charNum);
						
						if(digit % 3 == 0)
							result += charNum + " ";
					}
					
					Main.showText(String.format("����� ������� ������ 3: %s", result));
					Main.waitUser();
					
				}catch(NumberFormatException e)
				{
					Main.showText(String.format("[ERROR_INPUT] � ������� \"������� �����\" ���� ������������ ������ %s, ��������� ����", errorArg));
					Main.openTask(3);
				}
				
			}else
			{
				Main.showText("[ERROR_INPUT] ������ ����������� �������, ���������� �����");
				Main.openTask(3);
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
