package com.example.finaluri



object QueAns {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Questions> {
        val questionsList = ArrayList<Questions>()


        val que1 = Questions(
            1, "გამოიცანით ფილმი",
            R.drawable.chrichina,
            "აბეზარა", "ჭრიჭინა",
            "მაია წყნეთელი", "ჩვენი ეზო", 2
        )

        questionsList.add(que1)

        val que2 = Questions(
            2, "გამოიცანით ფილმი",
            R.drawable.cisferimtebi,
            "ქოლგა", "შერეკილები",
            "ცისფერი მთები", "ფერისცვალება", 3
        )

        questionsList.add(que2)

        val que3 = Questions(
            3, "გამოიცანით ფილმი",
            R.drawable.gimilisbichebi,
            "ნერგები", "მე ვხედავ მზეს",
            "მშობლიურო ჩემო მიწავ", "ღიმილის ბიჭები", 4
        )

        questionsList.add(que3)


        val que4 = Questions(
            4, "გამოიცანით ფილმი",
            R.drawable.jariskacismama,
            "დღე უკანასკნელი, დღე პირველი", "მალე გაზაფხული მოვა",
            "ჯარისკაცის მამა", "პალიატომი", 3
        )

        questionsList.add(que4)


        val que5 = Questions(
            5, "გამოიცანით ფილმი",
            R.drawable.mebebiailikodailarioni,
            "მე,ბებია, ილიკო და ილარიონი", "თოჯინები იცინიან",
            "მე ვხედავ მზედ", "არ იდარდო", 1
        )

        questionsList.add(que5)

        val que6 = Questions(
            6, "გამოიცანით ფილმი",
            R.drawable.natvrisxe,
            "როცა აყვავდა ნუში", "ნატვრის ხე",
            "სხვისი შვილები", "ჭირვეული მეზობლები", 2
        )

        questionsList.add(que6)

        val que7 = Questions(
            7, "გამოიცანით ფილმი",
            R.drawable.rachachemisiyvaruli,
            "ჩიორა", "სიყვარული ყველას უნდა",
            "რაჭა, ჩემო სიყვარულო", "იმერული ესკიზები", 3
        )

        questionsList.add(que7)


        val que8 = Questions(
            8, "გამოიცანით ფილმი",
            R.drawable.sherekilebi,
            "ფერისცვალება", "რაც გინახავს ვეღარ ნახავ",
            "არასერიოზული კაცი", "შერეკილები", 4
        )

        questionsList.add(que8)


        val que9 = Questions(
            9, "გამოიცანით ფილმი",
            R.drawable.tojinebiicinian,
            "პირველი მერცხალი", "თოჯინები იცინიან",
            "ქვევრი", "გენერალი და ზიზილები", 2
        )

        questionsList.add(que9)


        val que10 = Questions(
            10, "გამოიცანით ფილმი",
            R.drawable.udzinartamze,
            "უძინართა მზე", "კარდაკარ",
            "პიერი მილიციის თანამშრომელი", "მოკვეთილი", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}