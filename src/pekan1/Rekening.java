package pekan1;
public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	public Rekening(String nomor,String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat dengan saldo Rp" + saldo);
	}

	public void setorTunai(double nominal) {
		if (nominal > 10000) {
			saldo += nominal;
			System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini: Rp" + saldo);
		} else {
			System.out.println("Gagal: Nominal setor harus lebih dari 10000!");
		}
	}
	
	public void tarikTunai(double nominal) {
		if (nominal >= 10000) {
			if ( nominal > saldo) {
				System.out.println(" Transaksi gagal: Saldo tidak mencukupi. Saldo Anda: Rp" + saldo);
			} 
			else{saldo -= nominal;
				System.out.println("Tarik tunai" + nominal + " berhasil. Saldo saat ini: Rp" + saldo);
			}		
		} else {
			System.out.println("Gagal: Nominal tarik harus lebih dari 10000!");
		}
	}
	
	public void cekInformasi() {
		System.out.println("--- INFO REKENIG ---");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemilik : " + namaPemilik);
		System.out.println("Saldo Akhir  :Rp" + saldo);
		System.out.println("--------------------");
	}
}
