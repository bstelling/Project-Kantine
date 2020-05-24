//public class KantineSimulatie {
//
//    private Kantine kantine;
////    private Persoon persoon;
////    private Dienblad dienblad;
////    private Kassa kassa;
////    private KantineAanbod kantineAanbod;
//
//
//    public static final int DAGEN = 7;
//
//    /**
//     * Constructor
//     */
//    public KantineSimulatie() {
//        kantine = new Kantine();
//
//    }
//
//    /**
//     * Deze methode simuleert een aantal dagen in het
//     * verloop van de kantine
//     *
//     * @param dagen
//     */
//    public void simuleer(int dagen) {
//
//        // herhaal voor elke dag
//        for (int i = 0; i<dagen; ++i) {
//
//            // per dag nu even vast 10 + i personen naar binnen
//            // laten gaan, wordt volgende week veranderd...
//
//            // for lus voor personen
//            for (int j = 0; j < 10 + i; j++) {
//                kantine.loopPakSluitAan();
////                this.persoon = new Persoon();
////                this.dienblad = new Dienblad();
//
//            }
//
//            // verwerk rij voor de kassa
//            kantine.verwerkRijVoorKassa();
//
//            // toon dagtotalen (artikelen en geld in kassa)
//            System.out.println(kantine.getKassa().hoeveelheidGeldInKassa());
//            System.out.println(kantine.getKassa().aantalArtikelen());
//            // reset de kassa voor de volgende dag
//            kantine.resetKassa();
//        }
//    }
//
//    /**
//     * Start een simulatie
//     */
//    public static void main(String[] args) {
//        int dagen;
//
//        if (args.length == 0) {
//            dagen = DAGEN;
//        } else {
//            dagen = Integer.parseInt(args[0]);
//        }
//
//        simuleer(dagen);
//    }
//}
