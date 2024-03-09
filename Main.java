import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data mahasiswa
        Mahasiswa[] mahasiswas = new Mahasiswa[4];
        for (int i = 0; i < mahasiswas.length; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1));
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Nilai: ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            mahasiswas[i] = new Mahasiswa(nim, nama, nilai);
        }

        // Menampilkan data mahasiswa
        System.out.println("=======================");
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.println("NIM    : " + mahasiswa.nim);
            System.out.println("Nama   : " + mahasiswa.nama);
            System.out.println("Nilai  : " + mahasiswa.nilai);
            System.out.println("Grade  : " + mahasiswa.grade);
            System.out.println("=====================================");
        }

        // Menampilkan jumlah mahasiswa
        System.out.println("Jumlah Mahasiswa: " + mahasiswas.length);
        System.out.println("=====================================");

        // Menghitung statistik
        int lulus = 0;
        int tidakLulus = 0;
        int totalNilai = 0;
        int nilaiA = 0;
        int nilaiB = 0;
        int nilaiC = 0;
        int nilaiD = 0;

        for (Mahasiswa mahasiswa : mahasiswas) {
            if (mahasiswa.grade.equals("A") || mahasiswa.grade.equals("B") || mahasiswa.grade.equals("C")) {
                lulus++;
            } else {
                tidakLulus++;
            }

            totalNilai += mahasiswa.nilai;

            switch (mahasiswa.grade) {
                case "A":
                    nilaiA++;
                    break;
                case "B":
                    nilaiB++;
                    break;
                case "C":
                    nilaiC++;
                    break;
                case "D":
                    nilaiD++;
                    break;
            }
        }

        double rataRata = (double) totalNilai / mahasiswas.length;

        // Menampilkan statistik
        System.out.println("Jumlah Mahasiswa yg Lulus: " + lulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus: " + tidakLulus);
        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + nilaiA + " yaitu:");
        tampilkanNamaMahasiswa(mahasiswas, "A");

        System.out.println("Jumlah Mahasiswa dengan Nilai B = " + nilaiB + " yaitu:");
        tampilkanNamaMahasiswa(mahasiswas, "B");

        System.out.println("Jumlah Mahasiswa dengan Nilai C = " + nilaiC + " yaitu:");
        tampilkanNamaMahasiswa(mahasiswas, "C");

        System.out.println("Jumlah Mahasiswa dengan Nilai D = " + nilaiD + " yaitu:");
        tampilkanNamaMahasiswa(mahasiswas, "D");

        System.out.print("Rata-rata nilai mahasiswa adalah: ");
        for (int i = 0; i < mahasiswas.length; i++) {
            System.out.print(mahasiswas[i].nilai);
            if (i < mahasiswas.length - 1) {
                System.out.print("+");
            } else {
                System.out.print("/");
            }
        }
        System.out.print(mahasiswas.length + "=" + rataRata);

        scanner.close();
    }

    private static void tampilkanNamaMahasiswa(Mahasiswa[] mahasiswas, String grade) {
        for (Mahasiswa mahasiswa : mahasiswas) {
            if (mahasiswa.grade.equals(grade)) {
                System.out.println("- " + mahasiswa.nama);
            }
        }
    }
}