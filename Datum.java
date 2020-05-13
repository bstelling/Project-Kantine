public class Datum {

	private int dag;
	private int maand;
	private int jaar;
	private boolean isSchrikkelJaar;


	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}
	/**
	 * Constructor
	 */
	public Datum(int dag, int maand, int jaar){

	}


	//setter voor dag
	public void setDag(int dag) {
		this.dag = dag;
	}

	//setter voor maand
	public void setMaand(int maand) {
		this.maand = maand;
	}

	//setter voor Jaar
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	//getter voor Dag
	public int getDag() {
		return dag;
	}

	//getter voor Maand
	public int getMaand() {
		return maand;
	}

	//getter voor Jaar
	public int getJaar() {
		return jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar) {
		boolean bestaatDatum = false;
			if(jaar >= 1900 && jaar <= 2100){
				if (maand>=1 && maand<=12){
					if (dag>=1 && dag<=31){
						if (maand ==2) {
							if (checkSchrikkeljaar(jaar) && dag<= 29) this.dag = dag;
							else if (dag<= 28) this.dag=dag;

						}
						else if ( (maand<= 6 && maand%2==0 && dag <30) ||
						(maand<=7 && maand%2==1 )	||
						(maand>=8 && maand%2==0 ) ||
								(maand>= 9 && maand%2==1 && dag<=30)) this.dag = dag;
						else {
							this.dag = 0;
						}


					}
					else{ this.dag = 0;}
			}
				else { this.maand = 0;}

		}
			else {this.jaar = 0;}
		bestaatDatum = true;
		return bestaatDatum;
	}

	public boolean checkSchrikkeljaar(int jaar) {
		this.jaar = jaar;
		if(jaar % 4 == 0) {
			if((jaar % 100 == 0) && (jaar % 400 != 0 )) {
				this.isSchrikkelJaar = false;
			}
			else {
				this.isSchrikkelJaar = true;
			}
		}
			else {
			this.isSchrikkelJaar = false;
		}
		return this.isSchrikkelJaar;
	}



	/**
	 * Getter voor Sting weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO

			return dag + "-" + maand + "-" + jaar;
		}

}
