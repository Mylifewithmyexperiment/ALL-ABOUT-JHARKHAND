package ca.blogspot.sjatyourservice.allaboutjharkhand.Jharkhand_Quiz;

import java.util.Random;

/**
 * Created by SHASHI on 11-Sep-17.
 */

public class Question1001
{



    public String mQuestion1001[]=
            { "Where was the first Iron and Steel industry established in Jharkhand ?",
			  "In which of the following district's mines is the maximum iron-ore produced?",
               "From which mine is iron-ore supplied to TISCO?",
             "From which of the following mines is the ironore supplied to Bokaro ?"

			};


	private String mChoice[][]=
			{

					{  "Sakchi (Jamshedpur)", "Bokaro" , "Lohardagga ", "Ghatshila "
					},

					{    "Singhbhum" , "Hazaribagh" , "Palamu" , "Gumla"                    },
					{  " Bella Dellah" , "Noamundi ","Baba Budan" ,"Keonjhar"
					},

					{"Noamundi" , " Budan " ,"Bella Dellah " ,"Keonjhar" }
			};


	private String mCorrectAnswer[]=
			{ "Sakchi (Jamshedpur)","Singhbhum" ,"Noamundi ","Keonjhar"

			};



    public String getChoice1(int a)
    {
        String choice=mChoice[a][0];
        return choice;
    }

    public String getChoice2(int a)
    {
        String choice=mChoice[a][1];
        return choice;
    }

    public String getChoice3(int a)
    {
        String choice=mChoice[a][2];
        return choice;
    }

    public String getChoice4(int a)
    {
        String choice=mChoice[a][3];
        return choice;
    }

    public String getQuestion(int a)
    {
        String question = mQuestion1001[a];
        return question;
    }

    public String getCorrectAnswer1001(int a)
    {
        String answer=mCorrectAnswer[a];
        return answer;
    }


}
