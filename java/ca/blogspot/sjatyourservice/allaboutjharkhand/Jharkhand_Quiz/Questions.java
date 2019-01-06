package ca.blogspot.sjatyourservice.allaboutjharkhand.Jharkhand_Quiz;

import java.util.Random;

public class Questions
{

    public String mQuestion[]=
           {
           		"Most of the songs in folk culture of tribal areas of Jharkhand are–",
				 "Of which movement of Chhota Nagpur was Jatra Bhagat the main founder?",
				"Which of the following mineral is not produced in Jharkhand ?",
				"Who started the famous TISCO factory in Jharkhand ?",

				"Betla National Park is reserved for–",

				"Besides TISCO, where else has the iron and steel industry been established in " +
						"Jharkhand ?",

				"Which of the following religion people come to Parasnath hill as pilgrims?",



		   };


    private String mChoice[][]={
		{"Dance songs" , "Child songs" , "Marriage songs" , "Songs related with women " +
				"tradition" },

		{"Quit India movement","Non-cooperation movement",
				 "Champaran movement",  "Tana Bhagat movement"},
		{"Coal", "Thorium", "Uranium", "Petroleum"},

		{"Sachchidanand Sinha", "Dhirubhai Ambani", "Dr. Rajendra Prasad" , "Jamshedji Tata" },

		{"Lions", "Deers", " Bird and aquatic animals",
		 "Elephants"},

		{"Bokaro",  "Sindri",  "Ghatshila",  "Durgapur"},

		{"Hindu", "Muslim"," Sikh" , "Jain"
		}


            };


    private String mCorrectAnswer[]=
     {
            "Dance songs","Tana Bhagat movement","Petroleum", "Jamshedji Tata","Lions","Bokaro","Jain"
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
        String question = mQuestion[a];
        return question;
    }

    public String getCorrectAnswer(int a)
    {
        String answer=mCorrectAnswer[a];
        return answer;
    }


}



