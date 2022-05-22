package newsanalyzer.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import newsanalyzer.ctrl.Controller;
import newsapi.NewsApiException;

public class UserInterface 
{

	private Controller ctrl = new Controller();

	public void getDataFromCtrl1(){
		try {
			System.out.println(ctrl.process("Wirtschaft"));
		} catch (NewsApiException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getDataFromCtrl2(){
		try {
			System.out.println(ctrl.process("Politik"));
		} catch (NewsApiException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getDataFromCtrl3(){
		try {
			System.out.println(ctrl.process("Kultur"));
		} catch (NewsApiException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getDataForCustomInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Suche Schlagwort: ");
		String q = scanner.next();
		try {
			System.out.println(ctrl.process(q));
		} catch (NewsApiException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interface");
		menu.setTitel("Wählen Sie aus:");
		menu.insert("a", "Wirtschaft", this::getDataFromCtrl1);
		menu.insert("b", "Politik", this::getDataFromCtrl2);
		menu.insert("c", "Kultur", this::getDataFromCtrl3);
		menu.insert("d", "Schlagwort suche:",this::getDataForCustomInput);
		menu.insert("q", "Ende", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			 choice.run();
		}
		System.out.println("Programm beendet");
	}


    protected String readLine() {
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
        } catch (IOException ignored) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit) 	{
		Double number = null;
        while (number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                number = null;
				System.out.println("Please enter a valid number:");
				continue;
			}
            if (number < lowerlimit) {
				System.out.println("Please enter a higher number:");
                number = null;
            } else if (number > upperlimit) {
				System.out.println("Please enter a lower number:");
                number = null;
			}
		}
		return number;
	}
}
