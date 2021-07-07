//program to analyse data
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
public class Average {
    int min=0;int max=0;int _HCF,_LCM; int[] HCF;
    int[] HCF(int a) {
       int[] HCF = new int[a];
       // storing data items in the array
       for (int b=0; b<a; b++) {
        String c = JOptionPane.showInputDialog(null, "Data Input now!");
        HCF[b]=Integer.parseInt(c);
       } 
       //computing the maximum value of the data item
       for (int b=0;b<HCF.length;b++){
            if (HCF[b]>max) 
                max=HCF[b];
       } 
       //computing the minimum of value of the data items
       min=max;
       for (int b=0;b<HCF.length;b++) {
           if (HCF[b]<min)
                min=HCF[b];
       } 
       //computing the Hghest common factor and lowest common multiple of the data items
       int[] store = new int[a];
        //HCF
       foo:
       for (int b=max;b!=0;b--) {
           int sum=0;
            for (int i=0;i<HCF.length;i++){
                store[i] = (HCF[i] % b);}
            for (int c=0;c<store.length;c++) {
                    sum+= store[c];
                }  if (sum==0) {
                    _HCF=b;
                    break foo;
                } 
       } 
       //LCM
       int mul=1;
       for (int i=0;i<HCF.length;i++) {
           mul=mul*HCF[i];
        } 
        foo:
       for (int k = min;k<=mul;k++) {
        int sum=0;
        for (int i=0;i<HCF.length;i++){
            store[i] = (k % HCF[i]); 
        } for (int c=0;c<store.length;c++) {
            sum+= store[c];
        }  if (sum==0) {
            _LCM=k;
            break foo;
        } 
       }
       //mean value
       int sum=0;
       for (int i=0;i<HCF.length;i++) {
        sum=sum+HCF[i];}
        int average = sum/HCF.length;
        //Range
        int range=max-min;
        //sort
        for (int i=0;i<HCF.length;i++) {
            for (int j=i+1;j<HCF.length;j++) {
                if (HCF[j]<HCF[i]) {
                    int temp=HCF[j];
                    HCF[j]=HCF[i];
                    HCF[i]=temp;
                }
            }
        }int median;
        if (HCF.length % 2 !=0) {median=HCF[(HCF.length)/2];}
        else{
            median=((HCF[((HCF.length)/2) -1]) + (HCF[(HCF.length)/2]))/2;
        }
        JOptionPane.showMessageDialog(null,"The Minimum value is  " +min +"\n The Maximum value is  " + max +" \n The HCF is" + _HCF +"\n The LCM is " + _LCM +"\n  The mean value is " + average +   "\nThe Range value is  " + range +"\n The Median is " + median);
       int p = JOptionPane.showConfirmDialog(null,"do you want to search for the index of any data item");
       if (p != JOptionPane.NO_OPTION) {
       String d =JOptionPane.showInputDialog(null,"Enter the item to be searched for");
       int b = Integer.parseInt(d);
       for (int i=0;i<HCF.length;i++) {
           if (HCF[i]==b) JOptionPane.showMessageDialog(null,"Item found at index" + i);
       } 
    }     
       return (HCF);
   }
     public static void main(String[] args) {
       String k = JOptionPane.showInputDialog(null, "How many Data Items would you like to analyse");
       int c=Integer.parseInt(k);
       Average bridge = new Average();
       bridge.HCF(c);
   }
}
