package AQA_AutoTrainee.Tasks;

import java.util.Scanner;

import AQA_AutoTrainee.Main;

public class Second_Task implements ITask
{
	protected String taskNumber = "�2 - %s";
	protected String task = "������� ���: ";
	
	private String checkedName = "��������";
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
					Main.showText(String.format("������, %s", checkedName));
				else
					Main.showText("��� ������ �����");
				
				Main.waitUser();
			}else
			{
				Main.showText("[INPUT_ERROR] ������ �� ����� ���� ������, ���������� ��� ���");
				Main.openTask(2);
			}
		}else
		{
			Main.showText("[INPUT_ERROR] ������ �� ����� ���� ������, ���������� ��� ���");
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
