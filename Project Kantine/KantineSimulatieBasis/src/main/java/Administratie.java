public class Administratie {

  /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
   *
   * 2c alles wordt teruggegeven met een return statement die je in een main methode kan gooien die het dan weer ophaalt. er wordt alleen iets uitgerekend.
   * 2d er wordt alleen iets uitgerekend je kunt ze gelijk ophalen hij hoort bij de klasse en niet instanties van de klasse.
     */
    /**
     * Maakt een object, omdat de constructor private is kan er geen instantie van administratie gemaakt worden.
     */
    private Administratie(){

    }

    public static double  berekenGemiddeldAantal(int[] aantal) {
      //   method body omitted
    //    als de array leeg is, return 0.0
     if(aantal.length==0) return 0.0;
    // variabelen aanmaken
     int som=0;
     double gemiddelde=0;
  //  alle getallen optellen
    for(int i=0;i<aantal.length;i++)
     som+=aantal[i];
  // double maken van de int;
    double som2 = som;
 //   gemiddelde berekenen
    gemiddelde=som2/aantal.length;
    return gemiddelde;
    }

   /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
    * @param omzet
     * @return het gemiddelde
    */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        // method body omitted
        // als array leeg is return 0.0
        if (omzet.length == 0) return 0.0;
        double som = 0;
        double gemiddelde = 0;
        for (int i=0; i<omzet.length;i++)
            som+=omzet[i];

        gemiddelde=som/omzet.length;
        return gemiddelde;
    }

   /**
    * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
    * final kan niet override worden van welke klasse dan ook. de value kan niet meer veranderd worden.
     */

    public static double[] berekenDagOmzet(double[] omzet) {

        if(omzet.length==0) return null;
        final int DAYS_IN_WEEK = 7;
        //nieuwe arraylsist met omvang van variabelen days_in_week;
        double[] temp = new double[DAYS_IN_WEEK];
        //alle getallen bij langs gaan;
        for(int i = 0; i < 7; i++) {


            int j = 0;
            //zelfde dag bij elkaar optellen;
            while (i+DAYS_IN_WEEK*j<omzet.length) {
                //opslaan in nieuwe variabele;
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                    j++;
                // omitted

            }
        }
        return temp;
    }
}