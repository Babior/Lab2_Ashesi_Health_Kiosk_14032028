import java.util.Scanner;
public class HealthKiosk{
public static void main(String args[]){
System.out.println("Welcome to Ashesi Health Kiosk");
Scanner inputs = new Scanner(System.in);
//Task 1
System.out.println("Enter service code (P/L/T/C)");
char serviceCode = inputs.next().charAt(0); 
char upperserviceCode = Character.toUpperCase(serviceCode);
switch (upperserviceCode) {
  case 'P' :
  System.out.println("Go to Pharmacy Desk");
  break;
  case 'L':
  System.out.println("Go to Lab Desk");
  break;
  case 'T':
  System.out.println("Go to Triage Desk");
  break;
  case 'C':
  System.out.println("Go to Counselling Desk");
  break;
  default:
  System.out.println("Invalid service code.");
  }
//Task 2
System.out.println("Enter the health metric");
System.out.println("1. BMI");
System.out.println("2. Dosage round-up");
System.out.println("3. Simple trig helper.");
int healthMetric = inputs.nextInt();
int metricInt = -1;
double bmi = Double.NaN; 
switch (healthMetric) {
  case 1:
  System.out.println("Enter your weight in kg");
  double weightKg = inputs.nextDouble();
  System.out.println("Enter your height in meters");
  double heightMeters = inputs.nextDouble();
  bmi = weightKg / Math.pow(heightMeters, 2);
  bmi = Math.round(bmi * 10)/ 10.0;
  System.out.println("Your bmi is "+ bmi);
  if (bmi < 18.5){
  System.out.println("Underweight");
  }
  else if (bmi >= 18.5 && bmi <= 24.9 ){
  System.out.println("Normal");
  }
  else if (bmi >= 25.0 && bmi <= 29.9 ){
  System.out.println("Overweight");
  }
  else{
  System.out.println("Obese");
  }
  metricInt = (int) Math.round(bmi);
  break;
  case 2:
  System.out.println("Prompt the user to enter the required dosage in mg");
  double dosageMg = inputs.nextDouble();
  final int PHARMACYDOSAGE = 250;
  int noTablets = (int) Math.ceil(dosageMg / PHARMACYDOSAGE);
  System.out.println("The number of tablets is " + noTablets);
  metricInt = noTablets;
  break;
  case 3:
  System.out.println("Enter an angle in degrees");
  double degrees = inputs.nextDouble();
  double radians = Math.toRadians(degrees);
  double sinValue = Math.sin(radians);
  double cosValue = Math.cos(radians);
  sinValue = Math.round(sinValue * 1000) / 1000.0;
  cosValue  = Math.round(cosValue * 1000) / 1000.0;
  System.out.println("sin of " + degrees + " = " + sinValue);
  System.out.println("cos of " + degrees + " = " + cosValue);
  metricInt = (int) Math.round(Math.sin(radians) * 100);
  break;
  }
  // task 3
  int min = 3;
  int max = 9;           
  int firstNo = (int)(Math.random() * (max - min + 1)) + min;
  int secondNo = (int)(Math.random() * (max - min + 1)) + min;
  int thirdNo = (int)(Math.random() * (max - min + 1)) + min;
  int fourthNo = (int)(Math.random() * (max - min + 1)) + min;
  char letter = (char) ('A' + (int)(Math.random() * 26));
  String shortCode = "" + letter + firstNo + secondNo + thirdNo + fourthNo ;
  System.out.println(shortCode);
  int lengthOfCode = shortCode.length();
  char firstLetter = shortCode.charAt(0);
  char d1 = shortCode.charAt(1);
  char d2 = shortCode.charAt(2);
  char d3 = shortCode.charAt(3);
  char d4 = shortCode.charAt(4);
if ( lengthOfCode != 5 ){
System.out.println(" Invalid length");}
else if ( !Character.isLetter(firstLetter) ){
  System.out.println("Invalid, first char must be a letter");}
else if (!Character.isDigit(d1) || !Character.isDigit(d2) || !Character.isDigit(d3) || !Character.isDigit(d4)) {
  System.out.println("Invalid: last 4 must be digits"); } 
  else {
  System.out.println("ID OK");}
  //task 4
  System.out.println("Enter your first name");
  inputs.nextLine();
  String firstName = inputs.nextLine();
  char base = Character.toUpperCase(firstName.charAt(0));
  System.out.println(base);
  char shifted = (char) ('A' + (base - 'A' + 2) % 26);
  String lastTwo = shortCode.substring(shortCode.length() - 2);
  String codeFormat = "" + shifted + lastTwo + "-" + metricInt;
  System.out.println(codeFormat);
  String serviceName;
switch (upperserviceCode) {
    case 'P': serviceName = "PHARMACY";   break;
    case 'L': serviceName = "LAB";        break;
    case 'T': serviceName = "TRIAGE";     break;
    case 'C': serviceName = "COUNSELING"; break;
    default:  serviceName = "UNKNOWN";
}
System.out.println( "Summary: " + serviceName + " | ID=" + shortCode + " | BMI=" + String.format("%.1f", bmi) + " | Code=" + codeFormat);

}
}