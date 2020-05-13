public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Constructor
	 *
	 */
	public Datum(int dag, int maand, int jaar){
		if(bestaatDatum(dag, maand, jaar)){
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}


	/**
	 * Setter voor de dag.
	 *
	 * @param dag
	 */
	public void setDag(int dag) {
		this.dag = dag;
	}

	/**
	 * Setter  voor de maand.
	 *
	 * @param maand
	 */
	public void setMaand(int maand) {
		this.maand = maand;
	}

	/**
	 * Setter voor het jaar.
	 *
	 * @param jaar
	 */
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	/**
	 * Getter voor de dag.
	 *
	 * @return dag
	 */
	public int getDag() {
		return dag;
	}


	/**
	 * Getter voor de maand.
	 *
	 * @return maand
	 */
	public int getMaand() {
		return maand;
	}

	/**
	 * Getter voor het jaar.
	 *
	 * @return jaar
	 */
	public int getJaar() {
		return jaar;
	}

	/**
	 * Boolean methode om uit te zoeken of een jaar een schrikkeljaar is of niet.
	 *
	 * @param jaar dat gecheckt wordt
	 * @return true of false afhankelijk van schrikkeljaar of geen schrikkeljaar.
	 */
	public boolean isSchrikkelJaar(int jaar){
		if((jaar % 400 == 0) && (jaar % 4 == 0)){
			return true;
		}
			return false;
	}

	/**
	 * Methode die controleert of een datum bestaat, e.g 30 februari 2000 bestaat niet.
	 * @param dag
	 * @param maand
	 * @param jaar
	 * @return of de datum bestaat of niet.
	 */
	public boolean bestaatDatum(int dag, int maand, int jaar){
		if((dag >= 1) && (maand >= 1 && maand <= 12) && (jaar >= 1900 && jaar <= 2100)) {
			switch(maand){
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if(dag <= 31){
						return true;
					}
				case 2:
					if(isSchrikkelJaar(jaar)) {
						if(dag <= 29) {
							return true;
						}
					}
					else if(dag <= 28) {
						return true;
					}

				case 4: case 6: case 9: case 11:
					if(dag <= 30){
						return true;
					}
			}
		}
		return false;
	}


	/**
	 * Getter die de datum retourneert als String.
	 *
	 * @return Geboortedatum als String
	 */
	public String getDatumAsString() {
		// TODO

			return dag + "-" + maand + "-" + jaar;
		}

}
