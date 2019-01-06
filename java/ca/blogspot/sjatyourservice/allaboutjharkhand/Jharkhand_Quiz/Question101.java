package ca.blogspot.sjatyourservice.allaboutjharkhand.Jharkhand_Quiz;

import java.util.Random;

/**
 * Created by SHASHI on 11-Sep-17.
 */

public class Question101 {



    public String mQuestion101[]=
            {

            		"When did the tribal revolution of Chhota Nagpur take place?",

                    "When was the Ranchi district Tana Bhagat reha-bilitation ordinance passed?",


			            "Which of the following is main tribal caste living in the state?",


		             " What do the Munda tribes call themselves?",





			 "In which part of Jharkhand is maximum rainfall being recorded ?",







            };



	private String mChoice[][]=
			{
					{       "1807-08" , "1820" , "1858-59" , "1889"        },


		{                "1948" , "1952" , "1977 ", "1980"                       },

		{                "Munda" , "Hoo" ," Asur" , "Gond"                       },
		{                  "Korakh ", "Nagra" , "Horko ", "None of these "},
		{        "Chatra" , "Neterhat plateau" , "Ranchi plateau ", "Bokaro"},














		};


	private String mCorrectAnswer[]=
			{"1858-59","1948" , "Hoo", "Horko ", "Neterhat plateau"

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
        String question = mQuestion101[a];
        return question;
    }

    public String getCorrectAnswer101(int a)
    {
        String answer=mCorrectAnswer[a];
        return answer;
    }


}
