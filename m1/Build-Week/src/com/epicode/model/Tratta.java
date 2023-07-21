package com.epicode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.epicode.enumerators.Citta;

@Entity
public class Tratta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Citta partenza;
	
	@Enumerated(EnumType.STRING)
	private Citta capolinea;
	
	@Column(name = "tempo_medio")
	private double tempoMedio;
	
	@Column(name = "is_traffico")
	private boolean isTraffico;
	
	@ManyToMany
	private List<Mezzo> mezziTratta;
	
	private int contatore = 0;
	
	
	public Tratta() {}

	public Tratta(Citta partenza, Citta capolinea, boolean isTraffico) {
		super();
		this.partenza = partenza;
		this.capolinea = capolinea;
		this.isTraffico = isTraffico;
		
		this.tempoMedio = this.getTempoByTratte(partenza, capolinea);
		if (this.isTraffico) this.tempoMedio += 1;
	}

	public Citta getPartenza() {
		return partenza;
	}

	public void setPartenza(Citta partenza) {
		this.partenza = partenza;
	}

	public Citta getCapolinea() {
		return capolinea;
	}

	public void setCapolinea(Citta capolinea) {
		this.capolinea = capolinea;
	}

	public double getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(double tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public boolean isTraffico() {
		return isTraffico;
	}

	public void setTraffico(boolean isTraffico) {
		this.isTraffico = isTraffico;
	}

	public long getId() {
		return id;
	}

	public List<Mezzo> getMezziTratta() {
		return mezziTratta;
	}

	public void setMezziTratta(List<Mezzo> mezziTratta) {
		this.mezziTratta = mezziTratta;
	}
	
	

	public int getContatore() {
		return contatore;
	}

	public void setContatore(int contatore) {
		this.contatore = contatore;
	}


	@Override
	public String toString() {
		return "Tratta [id=" + id + ", partenza=" + partenza + ", capolinea=" + capolinea + ", tempoMedio=" + tempoMedio + "h"
				+ "]";
	}

	public double getTempoByTratte(Citta uno, Citta due) {
		switch (uno) {
			case ROMA: {
				switch (due) {
					case MILANO: {
						return 08.00;
					}
					case BOLOGNA: {
						return 07.00;
					}
					case BRESCIA: {
						return 07.40;
					}
					case VERONA: {
						return 10.30;
					}
					case VENEZIA: {
						return 11.20;
					}
					case TORINO: {
						return 09.10;
					}
					case BERGAMO: {
						return 06.50;
					}
					case CAMPOBASSO: {
						return 03.20;
					}
					case PESCARA: {
						return 02.50;
					}
					case VITERBO: {
						return 01.10;
					}
					case FROSINONE: {
						return 01.30;
					}
					case NAPOLI: {
						return 03.00;
					}
					case PALERMO: {
						return 09.50;
					}
				}
				break;
			}
			case VITERBO: {
				switch (due) {
					case MILANO: {
						return 07.50;
					}
					case BOLOGNA: {
						return 07.00;
					}
					case BRESCIA: {
						return 07.40;
					}
					case VERONA: {
						return 10.30;
					}
					case VENEZIA: {
						return 11.20;
					}
					case TORINO: {
						return 09.10;
					}
					case BERGAMO: {
						return 06.50;
					}
					case CAMPOBASSO: {
						return 03.20;
					}
					case PESCARA: {
						return 02.50;
					}
					case ROMA: {
						return 01.10;
					}
					case FROSINONE: {
						return 01.50;
					}
					case NAPOLI: {
						return 03.20;
					}
					case PALERMO: {
						return 10.40;
					}
				}
				break;
			}
			case FROSINONE: {
				switch (due) {
					case MILANO: {
						return 07.50;
					}
					case BOLOGNA: {
						return 07.00;
					}
					case BRESCIA: {
						return 07.40;
					}
					case VERONA: {
						return 10.30;
					}
					case VENEZIA: {
						return 11.20;
					}
					case TORINO: {
						return 09.10;
					}
					case BERGAMO: {
						return 06.50;
					}
					case CAMPOBASSO: {
						return 03.20;
					}
					case PESCARA: {
						return 02.50;
					}
					case ROMA: {
						return 01.10;
					}
					case VITERBO: {
						return 01.50;
					}
					case NAPOLI: {
						return 03.20;
					}
					case PALERMO: {
						return 10.40;
					}
				}
				break;
			}
			case MILANO: {
				switch (due) {
					case ROMA: {
						return 07.50;
					}
					case BOLOGNA: {
						return 03.00;
					}
					case BRESCIA: {
						return 02.10;
					}
					case VERONA: {
						return 04.20;
					}
					case VENEZIA: {
						return 06.20;
					}
					case TORINO: {
						return 02.50;
					}
					case BERGAMO: {
						return 03.50;
					}
					case CAMPOBASSO: {
						return 08.50;
					}
					case PESCARA: {
						return 08.10;
					}
					case VITERBO: {
						return 08.00;
					}
					case FROSINONE: {
						return 08.30;
					}
					case NAPOLI: {
						return 10.20;
					}
					case PALERMO: {
						return 14.40;
					}
				}
				break;
			}
			case BOLOGNA: {
				switch (due) {
					case ROMA: {
						return 07.20;
					}
					case MILANO: {
						return 03.00;
					}
					case BRESCIA: {
						return 02.00;
					}
					case VERONA: {
						return 04.10;
					}
					case VENEZIA: {
						return 05.00;
					}
					case TORINO: {
						return 02.30;
					}
					case BERGAMO: {
						return 02.00;
					}
					case CAMPOBASSO: {
						return 07.40;
					}
					case PESCARA: {
						return 06.50;
					}
					case VITERBO: {
						return 06.00;
					}
					case FROSINONE: {
						return 06.30;
					}
					case NAPOLI: {
						return 9.00;
					}
					case PALERMO: {
						return 11.40;
					}
				}
				break;
			}
			case BRESCIA: {
				switch (due) {
					case ROMA: {
						return 07.40;
					}
					case MILANO: {
						return 02.30;
					}
					case BOLOGNA: {
						return 02.00;
					}
					case VERONA: {
						return 04.20;
					}
					case VENEZIA: {
						return 05.10;
					}
					case TORINO: {
						return 02.20;
					}
					case BERGAMO: {
						return 01.50;
					}
					case CAMPOBASSO: {
						return 08.00;
					}
					case PESCARA: {
						return 07.30;
					}
					case VITERBO: {
						return 06.40;
					}
					case FROSINONE: {
						return 06.50;
					}
					case NAPOLI: {
						return 08.50;
					}
					case PALERMO: {
						return 13.00;
					}
				}
				break;
			}
			case VERONA: {
				switch (due) {
					case ROMA: {
						return 07.00;
					}
					case MILANO: {
						return 02.00;
					}
					case BOLOGNA: {
						return 01.50;
					}
					case BRESCIA: {
						return 02.20;
					}
					case VENEZIA: {
						return 02.00;
					}
					case TORINO: {
						return 02.50;
					}
					case BERGAMO: {
						return 02.00;
					}
					case CAMPOBASSO: {
						return 08.00;
					}
					case PESCARA: {
						return 07.30;
					}
					case VITERBO: {
						return 06.40;
					}
					case FROSINONE: {
						return 06.50;
					}
					case NAPOLI: {
						return 08.50;
					}
					case PALERMO: {
						return 13.00;
					}
				}
				break;
			}
			case VENEZIA: {
				switch (due) {
					case ROMA: {
						return 08.00;
					}
					case MILANO: {
						return 03.30;
					}
					case BOLOGNA: {
						return 02.30;
					}
					case BRESCIA: {
						return 02.40;
					}
					case VERONA: {
						return 02.00;
					}
					case TORINO: {
						return 03.10;
					}
					case BERGAMO: {
						return 02.40;
					}
					case CAMPOBASSO: {
						return 08.10;
					}
					case PESCARA: {
						return 07.20;
					}
					case VITERBO: {
						return 07.50;
					}
					case FROSINONE: {
						return 07.50;
					}
					case NAPOLI: {
						return 10.10;
					}
					case PALERMO: {
						return 15.00;
					}
				}
				break;
			}
			case TORINO: {
				switch (due) {
					case ROMA: {
						return 07.00;
					}
					case MILANO: {
						return 02.00;
					}
					case BOLOGNA: {
						return 02.30;
					}
					case BRESCIA: {
						return 02.40;
					}
					case VERONA: {
						return 02.50;
					}
					case VENEZIA: {
						return 03.50;
					}
					case BERGAMO: {
						return 02.40;
					}
					case CAMPOBASSO: {
						return 08.30;
					}
					case PESCARA: {
						return 07.10;
					}
					case VITERBO: {
						return 07.30;
					}
					case FROSINONE: {
						return 07.50;
					}
					case NAPOLI: {
						return 10.00;
					}
					case PALERMO: {
						return 14.30;
					}
				}
				break;
			}
			case BERGAMO: {
				switch (due) {
					case ROMA: {
						return 06.00;
					}
					case MILANO: {
						return 01.40;
					}
					case BOLOGNA: {
						return 02.00;
					}
					case BRESCIA: {
						return 01.40;
					}
					case VERONA: {
						return 02.50;
					}
					case VENEZIA: {
						return 04.00;
					}
					case TORINO: {
						return 02.20;
					}
					case CAMPOBASSO: {
						return 07.30;
					}
					case PESCARA: {
						return 06.20;
					}
					case VITERBO: {
						return 05.40;
					}
					case FROSINONE: {
						return 05.50;
					}
					case NAPOLI: {
						return 7.50;
					}
					case PALERMO: {
						return 11.00;
					}
				}
				break;
			}
			case CAMPOBASSO: {
				switch (due) {
					case ROMA: {
						return 03.00;
					}
					case MILANO: {
						return 08.40;
					}
					case BOLOGNA: {
						return 08.00;
					}
					case BRESCIA: {
						return 08.20;
					}
					case VERONA: {
						return 07.50;
					}
					case VENEZIA: {
						return 08.50;
					}
					case TORINO: {
						return 07.50;
					}
					case BERGAMO: {
						return 07.10;
					}
					case PESCARA: {
						return 03.20;
					}
					case VITERBO: {
						return 03.30;
					}
					case FROSINONE: {
						return 03.00;
					}
					case NAPOLI: {
						return 02.30;
					}
					case PALERMO: {
						return 07.00;
					}
				}
				break;
			}
			case PESCARA: {
				switch (due) {
					case ROMA: {
						return 02.50;
					}
					case MILANO: {
						return 08.00;
					}
					case BOLOGNA: {
						return 07.20;
					}
					case BRESCIA: {
						return 07.50;
					}
					case VERONA: {
						return 07.00;
					}
					case VENEZIA: {
						return 08.00;
					}
					case TORINO: {
						return 07.30;
					}
					case BERGAMO: {
						return 07.00;
					}
					case CAMPOBASSO: {
						return 02.30;
					}
					case VITERBO: {
						return 02.20;
					}
					case FROSINONE: {
						return 02.00;
					}
					case NAPOLI: {
						return 02.50;
					}
					case PALERMO: {
						return 07.30;
					}
				}
				break;
			}
			case NAPOLI: {
				switch (due) {
					case ROMA: {
						return 02.40;
					}
					case MILANO: {
						return 08.40;
					}
					case BOLOGNA: {
						return 08.00;
					}
					case BRESCIA: {
						return 08.20;
					}
					case VERONA: {
						return 08.00;
					}
					case VENEZIA: {
						return 09.30;
					}
					case TORINO: {
						return 07.50;
					}
					case BERGAMO: {
						return 07.00;
					}
					case CAMPOBASSO: {
						return 02.30;
					}
					case VITERBO: {
						return 03.00;
					}
					case FROSINONE: {
						return 02.40;
					}
					case PESCARA: {
						return 02.50;
					}
					case PALERMO: {
						return 07.00;
					}
				}
				break;
			}
			case PALERMO: {
				switch (due) {
					case ROMA: {
						return 07.00;
					}
					case MILANO: {
						return 15.00;
					}
					case BOLOGNA: {
						return 14.20;
					}
					case BRESCIA: {
						return 14.50;
					}
					case VERONA: {
						return 14.30;
					}
					case VENEZIA: {
						return 15.00;
					}
					case TORINO: {
						return 14.40;
					}
					case BERGAMO: {
						return 12.30;
					}
					case CAMPOBASSO: {
						return 7.30;
					}
					case VITERBO: {
						return 08.30;
					}
					case FROSINONE: {
						return 08.20;
					}
					case PESCARA: {
						return 08.00;
					}
					case NAPOLI: {
						return 07.00;
					}
				}
				break;
			}
		}
		return 0;
	}
}























