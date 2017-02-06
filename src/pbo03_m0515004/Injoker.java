package pbo03_m0515004;

import java.util.Scanner;							
import javax.swing.JOptionPane;

public class Injoker {			//membuat class bernama Injoker
	public Injoker() {			//membuat konstruktor tanpa parameter
		System.out.println("\tINJOKER SKILL");
		System.out.println("(QWE) QUAS WEX EXORT");
	}
	
	public Injoker(String orbs) {		//membuat konstruktor dengan parameter orbs bertipe String
		System.out.println("\nInvoke " + orbs.toUpperCase());
		System.out.print("Your abilities : ");
	}

	public static int Invoke(int a, int b, int c, int mana) { 		//method Invoke dengan pengembalian int untuk mencari Skill mana yang akan terbentuk
		int manaCost;												//mendeklarasikan manaCost
		if (a == 3) {
			System.out.println("Cold Snap");						
			manaCost = 100;											//memberi nilai manaCost untuk nilai Quas = 3
		} else if (a == 2 && b == 1) {
			System.out.println("Ghost Walk");
			manaCost = 200;											//memberi nilai manaCost untuk nilai a = 2 dan b = 1
		} else if (a == 2 && c == 1) {
			System.out.println("Ice Wall");
			manaCost = 75;											//memberi nilai manaCost untuk nilai a = 2 dan c = 1
		} else if (b == 3) {
			System.out.println("EMP");
			manaCost = 200;											//memberi nilai manaCost untuk nilai b = 3
		} else if (b == 2 && a == 1) {
			System.out.println("Tornado");
			manaCost = 200;											//memberi nilai manaCost untuk nilai b = 2 dan a = 1
		} else if (b == 2 && c == 1) {
			System.out.println("Alacrity");
			manaCost = 125;											//memberi nilai manaCost untuk nilai b = 2 dan c = 1 
		} else if (c == 3) {
			System.out.println("Sun Strike");
			manaCost = 175;											//memberi nilai manaCost untuk nilai c = 3
		} else if (c == 2 && a == 1) {
			System.out.println("Forge Spirit");
			manaCost = 250;											//memberi nilai manaCost untuk nilai c = 2 dan a = 1
		} else if (c == 2 && b == 1) {
			System.out.println("Chaos Meteor");
			manaCost = 200;											//memberi nilai manaCost untuk nilai c = 2 dan b = 1
		} else {
			System.out.println("Deafening Blast");
			manaCost = 300;											//memberi nilai manaCost selain nilai diatas
		}
		int manaLeft = mana - manaCost;									//digunakan untuk menghitung manaLeft
		if (manaLeft < 0) {												//ketika manaLeft dibawah 0 akan masuk ke decision
			JOptionPane.showMessageDialog(null, "No Mana, You Die", "Death", JOptionPane.ERROR_MESSAGE);	//membuat dialog box bertipe Error message
			JOptionPane.showMessageDialog(null, "DEATH", "Death", JOptionPane.INFORMATION_MESSAGE);			//membuat dialog box bertipe Information message
			System.exit(0);												//untuk mengakhiri program												
		}
		System.out.println("Your mana : " + manaLeft);
		return manaLeft;												//mengembalikan nilai manaLeft
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);							//membuat objek in dari konstruktor Scanner dengan parameter System.in
		Injoker kael = new Injoker();									//membuat objek kael dari konstruktor Injoker()
		int mana = 2250;												//mendeklarasikan mana bertipe integer dengan nilai 2250
		int again = 0;													//mendeklarasikan mana bertipe integer dengan nilai 0
		while (again == 0) {											//membuat looping dengan syarat akan lanjut jika nilai again = 0
			int countQ = 0, countW = 0, countE = 0;						//mendeklarasikan nilai countQ, countW, dan countE bernilai 0 debgan tipe integer
			System.out.println("Type the orbs combination ex: QWE\nThen, click enter to invoke");
			String skill = in.next();									//mendeklarasikan String bernama skill sekaligus untuk input
			for (int i = 0; i < 3; i++) {								//looping for untuk menghitung tiap indeks dari char						
				char orb = skill.toLowerCase().charAt(i);				//mencari char satu persatu dari 3 huruf terdepan
				if (orb == 'q')											
					countQ++;											//ketika orb = q maka akan menambah countQ
				else if (orb == 'w')
					countW++;											//ketika orb = w maka akan menambah countW
				else if (orb == 'e')
					countE++;											//ketika orb = e maka akan menambah countE
				else{													//ketika char tidak ada yang sama maka akan muncul error 
					JOptionPane.showMessageDialog(null, "Wrong Combination, You Die","Death", JOptionPane.ERROR_MESSAGE);	//membuat dialog box bertipe Error message
					JOptionPane.showMessageDialog(null, "DEATH", "Death", JOptionPane.INFORMATION_MESSAGE);					//membuat dialog box bertipe Information message
					System.exit(0);										//untuk mengakhiri program
				}
			}
			Injoker kael1 = new Injoker(skill);							//membuat objek kael dari konstruktor Injoker(skill) dengan parameter skill
			mana = Invoke(countQ, countW, countE, mana);				//memanggil method Invoke dengan parameter countQ, countW, countE, dan mana
			int n = JOptionPane.showConfirmDialog(null, "Invoke again?","Again",JOptionPane.YES_NO_OPTION);			//membuat dialog box untuk memilih yes atau no
			switch (n){										//decision switch case
				case JOptionPane.YES_OPTION: 				//ketika menekan tombol yes, membuat nilai again = 0 sehingga akan looping
					again = 0;
					break;								
				case JOptionPane.NO_OPTION:					//ketika menekan tombol no, membuat nilai again = 1 sehingga akan looping
					again = 1;
					JOptionPane.showMessageDialog(null, "TY M0515004","Exit", JOptionPane.INFORMATION_MESSAGE); //membuat dialog box bertipe Information m
					System.exit(0);							//untuk mengakhiri program
					break;
			}
		}
	}
}