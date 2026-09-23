package pekan3;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Rekening> daftarRekening = new ArrayList<>();
		Rekening akunAktif = null; 
		boolean isRunning = true;
		
		System.out.println("=== SISTEM PERBANKAN MINI ===");
		
		while (isRunning) {
			System.out.println("\nMenu Utama");
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik Tunai");
			System.out.println("4. Cek Informasi Rekening");
			System.out.println("5. Ganti Akun");
			System.out.println("6. Cetak Mutasi (Riwayat)");
			System.out.println("0. Keluar");
			System.out.print("Pilih Menu: ");
			
			int pilihan = input.nextInt();
			input.nextLine(); // Membersihkan buffer enter
			
			switch (pilihan) {
			case 1:
				System.out.print("Masukkan No Rekening: ");
				String no = input.nextLine();
				System.out.print("Masukkan Nama Pemilik: ");
				String nama = input.nextLine();
				System.out.print("Masukkan Saldo Awal: ");
				double saldo = input.nextDouble();
				input.nextLine();
				System.out.print("Masukkan Pin Anda: ");
				String pin = input.nextLine();
				
				// instansiasi Object / menjalankan konstruktor
				Rekening rekeningBaru = new Rekening(no, nama, saldo, pin);
				daftarRekening.add(rekeningBaru);
				akunAktif = rekeningBaru;
				break;
				
			case 2:
				if (akunAktif == null) {
					System.out.println("Error: Mohon maaf, Anda belum memiliki nomor rekening!");
				} else {
					System.out.print("Masukkan nominal setor: ");
					double setor = input.nextDouble();
					akunAktif.setorTunai(setor); // Memanggil Behavior / Method
				}
				break;
				
			case 3:
				if (akunAktif == null) {
					System.out.println("Error: Mohon maaf, Anda belum memiliki nomor rekening!.");
				} else {
					System.out.println("Masukkan Pin Anda: ");
					String pinTarik = input.nextLine();
				
					if (akunAktif.otentikasi(pinTarik)) {
						System.out.println("Masukkan nominal tarik: ");
						double tarik = input.nextDouble();
						input.nextLine();
						akunAktif.tarikTunai(tarik);
					} else
					System.out.println("Akses ditolak! Pin yang anda masukkan salah");
				}
				break;
				
			case 4:
				if (akunAktif == null) {
					System.out.println("Error: Anda belum membuka rekening!");
				} else {
					akunAktif.cekInformasi();
				}
				break;
				
			case 5:
			    System.out.print("Masukkan No Rekening: ");
			    String nomorCari = input.nextLine();

			    Rekening akunDitemukan = null;

			    for (Rekening rekening : daftarRekening) {
			        if (rekening.getNomorRekening().equals(nomorCari)) {
			            akunDitemukan = rekening;
			            break;
			        }
			    }

			    if (akunDitemukan != null) {
			        akunAktif = akunDitemukan;
			        System.out.println("Berhasil mengganti akun.");
			    } else {
			        System.out.println("Rekening tidak ditemukan!");
			    }
			    break;
			    
			case 6:
			    if (akunAktif == null) {
			        System.out.println("Tidak ada rekening yang tersedia");
			    } else {
			        System.out.println("Masukkan PIN Anda");
			        String pinMutasi = input.nextLine();

			        if (akunAktif.otentikasi(pinMutasi)) {
			            akunAktif.cetakMutasi();
			        } else {
			            System.out.println("Akses Ditolak! PIN yang Anda masukkan salah!");
			        }
			    }
			    break;
			       
			case 0:
				isRunning = false;
				System.out.println("System ditutup. Terima Kasih!");
				break;
				
			default:
				System.out.println("Pilihan tidak valid");

			}
		}
		input.close();
	}

}
