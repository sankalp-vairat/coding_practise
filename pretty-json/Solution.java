public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        int length = A.length();
        ArrayList<String> outputList = new ArrayList<String>();
        int noOfTabs = 0;
        if(A == null)
            return null;
        for(int i=0; i < length; i++)
        {
                String temp = "";
                while((A.charAt(i) != '{') && (A.charAt(i) != '[') && (A.charAt(i) != ',') && A.charAt(i) != '}' && A.charAt(i) != ']')
                {
                    temp = temp + String.valueOf(A.charAt(i));
                    i++;
                }
               
                if(temp != "")
                {
                    for(int k=0; k < noOfTabs; k++)
                    {
                        temp = "\t" + temp;
                    }
                    if(A.charAt(i) == ',')
                        temp = temp + String.valueOf(',');
                    outputList.add(temp);
                }
                if((A.charAt(i)== '{' || A.charAt(i) == '['))
                {
                    String temp1 = String.valueOf(A.charAt(i));
                    for(int k=0; k < noOfTabs; k++)
                    {
                        temp1 = "\t" + temp1;
                    }
                    outputList.add(temp1);
                    noOfTabs++;
                }
                else if((A.charAt(i)== '}' || A.charAt(i) == ']'))
                {
                    noOfTabs--;
                    String temp1 = String.valueOf(A.charAt(i));
                    for(int k=0; k < noOfTabs; k++)
                    {
                        temp1 = "\t" + temp1;
                    }
                    if(((i+1)< length) && (A.charAt(i+1) == ','))
                    {
                        temp1 = temp1 + String.valueOf(',');
                        i++;
                    }
                    outputList.add(temp1);
                }
        }
        return outputList;
    }
}
