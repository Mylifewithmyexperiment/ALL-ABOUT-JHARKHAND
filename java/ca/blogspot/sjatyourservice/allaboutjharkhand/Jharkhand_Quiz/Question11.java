package ca.blogspot.sjatyourservice.allaboutjharkhand.Jharkhand_Quiz;

import java.util.Random;


public class Question11 {




    public String mQuestion11[]=
            {
            		"Which boys and girls of the following tribal people, is there no other " +
							 "important festival than Jatra ?",
					"Which of the following tribs is famous for truth and to sacrifice all for truth?",
					"Which of the following tribes is found in Palamu district of Jharkhand ?",
			" Normally what is known as the residence of the Birhar tribal people?",
			 "In which city of Jharkhand has the uranium processing factory been started ?",
					"Who is the author of Jharkhand : Castel over Graves?"

            };



    private String mChoice[][]=
            {
                    {    "Munda" , "Santhal" , "Orab" , "Kharia"         },
                    {    "Kharbar", " Munda", "Santhal" ," Sauria"    },
                    {    "Orab ", "Munda" , "Bhumij ","Korba"      },
	             	{	"Tonda", " Tole " ,"Dhumkuria" ," Akhare"},
	             	{ "Ranchi","Ghatshila" , "Garwa" , "Sahaibganj" },
		            { " Shibbu Soren" , "Shailendra Mahento" , "Victor Das" , "None of these"  }

            };


    private String mCorrectAnswer[]=
            { "Orab","Kharbar","Korba","Tonda","Ghatshila","Victor Das"

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
        String question = mQuestion11[a];
        return question;
    }

    public String getCorrectAnswer11(int a)
    {
        String answer = mCorrectAnswer[a];
        return answer;
    }

}
