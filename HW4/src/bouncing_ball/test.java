package bouncing_ball;

import java.util.Scanner;

public class test{
	public static void main(String[] args) {
		String line1, line2;
		Scanner scanner = new Scanner(System.in);
        System.out.println("Please decide width: ");
        line1=scanner.next();
        System.out.println("Please decide hight: ");
        line2=scanner.next();
        int width=Integer.parseInt(line1), hight=Integer.parseInt(line2);
        Bouncing_Balls a = new Bouncing_Balls(width,hight);
	}
}