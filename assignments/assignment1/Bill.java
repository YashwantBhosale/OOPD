/*
Enter cost of 3 items from the user (using float data type)- a pencil, a pen and a eraser.
You hve to output total cost of the items back to the user as their bill.
Additionally, you may also try to add 18% GST to the cost of the items as an advanced problem
 */
import java.util.Scanner;

public class Bill {
    float pencilCost, penCost, eraserCost;
    int pens, pencils, erasers;

    Bill(float pencilCost, float penCost, float eraserCost, int pens, int pencils, int erasers) {
        this.penCost = penCost;
        this.pencilCost = pencilCost;
        this. eraserCost = eraserCost;
        this.pens = pens;
        this.pencils = pencils;
        this.erasers = erasers;
    }

    public void generateBill() {
        System.out.println("================================================");
        System.out.println("BILL:");
        System.out.println("Item\tQuantity\tPrice\t\ttotal");
        System.out.println("Pen\t\t\t" + pens + "\t\t" + penCost + "\t\t" + (pens * penCost));
        System.out.println("Pencil\t\t" + pencils + "\t\t" + pencilCost + "\t\t" + (pencils * pencilCost));
        System.out.println("Eraser\t\t" + erasers + "\t\t" + eraserCost + "\t\t" + (erasers * eraserCost));
        System.out.println("GST(18%)\t" + (0.18 *  erasers + eraserCost + (erasers * eraserCost)));
        System.out.println("-------------------------------------------------");
        System.out.println("Total: " + ((pens * penCost) + (pencils * pencilCost) + (erasers * eraserCost) + (0.18 *  erasers + eraserCost + (erasers * eraserCost))));
    }

    public static void main(String[] args) {
        Bill bill = new Bill(10, 15, 20, 5, 10, 11);
        bill.generateBill();
        /*
        float _pencilCost, _penCost, _eraserCost;
        int _pens, _pencils, _erasers;
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter cost of: ");
        System.out.print("Pen: ");
        _penCost = reader.nextFloat();
        System.out.print("Pencil: ");
        _pencilCost = reader.nextFloat();
        System.out.print("Eraser: ");
        _eraserCost = reader.nextFloat();

        System.out.println("\nEnter Quantity: ");
        System.out.print("Pen: ");
        _pens = reader.nextInt();
        System.out.print("Pencil: ");
        _pencils = reader.nextInt();
        System.out.print("Eraser: ");
        _erasers = reader.nextInt();

        Bill bill = new Bill(_pencilCost, _penCost, _eraserCost, _pens, _pencils, _erasers);
        bill.generateBill();
        */
    }
}