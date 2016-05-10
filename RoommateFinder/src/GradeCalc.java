public class GradeCalc
{
    private static double input1;
    private static double input2;
    private static double input3;
    private static double input4;
    private static double input5;
    
    private static double weight1;
    private static double weight2;
    private static double weight3;
    private static double weight4;
    private static double weight5;
    
    private static double grade = 0.00;

    public static void main(String[] args)
    {
        input1 = 60;
        input2 = 70;
        input3 = 80;
        
        weight1 = .10;
        weight2 = .20;
        weight3 = .20;
        
        //You can change inputs (grades on assignments) and weights (how much % each weight is worth). 
        //Input 1 correlates with Weight1 etc
        //You can then call what grade you want, in this case a B.
        System.out.println(getCurrentGrade() + " " + getCurrentLetter(getCurrentGrade()));
        System.out.println("You will need a " + number4DesiredGrade(getCurrentGrade(), "B") + " to achieve your desired grade. ");
    }
    
    public static double getCurrentGrade()
    {
        grade = (helper()) / (currentPercent());
        return grade;
    }
    
    /**
     * You do this by subtracting your total number of points from the percentage you wish to receive. 
     * You then divide that number of points required by the exam mark breakdown percentage and 
     * times by 100% to calculate the percentage you need in order to get the desired percentage
     */
    public static double number4DesiredGrade(double currentGrade, String desiredGrade)
    {
        double val = neededGradeForLetter(desiredGrade);
        double curr = getCurrentGrade();
        double pointsEarned = curr * currentPercent();
        
        double step = (val - pointsEarned);
        double pointsOnExam = (1 - currentPercent());
        
        return (step / pointsOnExam);
    }
    
    public static double helper()
    {
        return (input1 * weight1) + (input2 * weight2) + (input3 * weight3) + (input4 * weight4) + 
        (input5 * weight5);
    }
    
    public static double currentPercent()
    {
        return weight1 + weight2 + weight3 + weight4 + weight5;
    }
    
    public static double neededGradeForLetter(String desiredGrade)
    {  
        if(desiredGrade.equals("A"))
        {
            return 94;
        }
        if(desiredGrade.equals("A-"))
        {
            return 93;
        }
        if(desiredGrade.equals("B+"))
        {
            return 87;
        }
        if(desiredGrade.equals("B"))
        {
            return 83;
        }
        if(desiredGrade.equals("B-"))
        {
            return 80;
        }
        if(desiredGrade.equals("C+"))
        {
            return 77;
        }
        if(desiredGrade.equals("C"))
        {
            return 73;
        }
        if(desiredGrade.equals("C-"))
        {
            return 70;
        }
        if(desiredGrade.equals("D+"))
        {
            return 67;
        }
        if(desiredGrade.equals("D"))
        {
            return 64;
        }
        if(desiredGrade.equals("D-"))
        {
            return 60;
        }
        if(desiredGrade.equals("F"))
        {
            return 59;
        }
        return 0;
    }      
    
    public static String getCurrentLetter(double currentGrade)
    {  
        if(currentGrade >= 94 && currentGrade <= 100)
        {
            return "A";
        }
        if(currentGrade >= 90 && currentGrade <= 94)
        {
            return "A-";
        }
        if(currentGrade >= 87 && currentGrade <= 90)
        {
            return "B+";
        }
        if(currentGrade >= 83 && currentGrade <= 87)
        {
            return "B";
        }
        if(currentGrade >= 80 && currentGrade <= 83)
        {
            return "B-";
        }
        if(currentGrade >= 77 && currentGrade <= 80)
        {
            return "C+";
        }
        if(currentGrade >= 73 && currentGrade <= 77)
        {
            return "C";
        }
        if(currentGrade >= 70 && currentGrade <= 73)
        {
            return "C-";
        }
        if(currentGrade >= 67 && currentGrade <= 70)
        {
            return "D+";
        }
        if(currentGrade >= 63 && currentGrade <= 67)
        {
            return "D";
        }
        if(currentGrade >= 60 && currentGrade <= 63)
        {
            return "D-";
        }
        if(currentGrade >= 59)
        {
            return "F";
        }
        return "";
    }      
}

