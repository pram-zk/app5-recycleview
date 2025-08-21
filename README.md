# Laporan Project Kelompok Menampilkan Data Dari API ke RecycleView
Ini adalah .

## 👥 Anggota Kelompok
1. Meriani Putri Suryaningtiyas
2. Muhammad Nauval Irkamsah
3. Nurin Ajrina Majdina
4. Pramudya Kalya Zaki

## 🎯 Tujuan Project


## 📱 Penjelasan Aplikasi

## 🔗 Komponen Utama Aplikasi

## 📚 Penjelasan Fitur
### Splash Screen
Fitur yang menampilkan tampilan pembuka sebelum masuk ke halaman utama aplikasi. Biasanya berisi logo atau nama aplikasi. Tujuannya memberi kesan awal yang menarik dan memberi waktu loading saat aplikasi dijalankan.
### RecyclerView
Komponen Android untuk menampilkan daftar data dalam bentuk list atau grid secara efisien. Data ditampilkan melalui Adapter dan ViewHolder, sehingga daftar bisa di-scroll dengan lancar meskipun jumlah datanya banyak.
### Intent 
Fitur untuk berpindah antar-activity atau mengirim data di dalam aplikasi. Misalnya, saat memilih salah satu item buku di daftar, aplikasi menggunakan Intent untuk membuka halaman DetailActivity sambil mengirim data buku yang dipilih.
### Toast
Fitur untuk menampilkan pesan singkat yang muncul sebentar di layar, tanpa mengganggu aktivitas pengguna. Biasanya digunakan untuk memberi notifikasi atau informasi sederhana yang cepat kepada pengguna.
### Dialog Box
Fitur berupa kotak dialog pop-up yang muncul di layar untuk meminta konfirmasi atau memberikan pilihan ke pengguna. Contohnya, ketika item buku diklik, muncul dialog berisi opsi Lihat Detail atau Batal.

## 🛠️ Penjelasan Struktur Folder atau File Project dan Alur Data
### Struktur Folder / File Project
#### A. manifests
- AndroidManifest.xml → berisi konfigurasi aplikasi, termasuk daftar Activity (MainActivity, SplashActivity, detail), tema aplikasi, ikon aplikasi, dan activity launcher (SplashActivity).
#### B. kotlin+java (package)
- Book.kt → data class untuk model buku (title, author, year).
- MainActivity.kt → activity utama, menampilkan daftar buku menggunakan RecyclerView.
- BookAdapter.kt → adapter RecyclerView yang mengatur bagaimana setiap item buku ditampilkan, serta aksi klik item (buka detail).
- detail.kt → activity untuk menampilkan detail buku (judul, penulis, tahun).
- SplashActivity.java ⏳ → activity awal (splash screen) sebelum masuk ke MainActivity.
#### C. layout (res/layout)
- activity_main.xml → tampilan utama, berisi RecyclerView.
- item_book.xml → layout untuk 1 item buku di RecyclerView (gambar, judul, penulis, tahun).
- activity_detail2.xml → layout halaman detail buku.
- activity_splash.xml → layout untuk splash screen (logo).
#### D. drawable (res/drawable)
- book1.png, logo_zaki.png → aset gambar buku dan logo aplikasi.
### Alur Data Aplikasi
#### A. SplashActivity 
-  Saat aplikasi dibuka, tampilkan logo (activity_splash.xml) selama 2 detik.
-  Setelah itu, pindah ke MainActivity.
#### B. MainActivity
- Menyimpan data buku (dengan membuat list ArrayList<Book>).
- Menyiapkan RecyclerView → diisi dengan BookAdapter.
- Data (title, author, year) dikirim ke adapter untuk ditampilkan.
#### C. BookAdapter 
- Mengatur tampilan setiap item buku menggunakan item_book.xml.
- Saat item diklik → muncul AlertDialog konfirmasi.
- Kalau pilih Lihat → kirim data buku ke detail Activity lewat Intent.putExtra().
- Kalau pilih Batal → dialog ditutup.
#### D. detail Activity 
- Menerima data (judul, author, year) dari intent.
- Menampilkan data di layout activity_detail2.xml (judul besar, penulis, tahun, gambar cover).
### Ringkasan Alur Data
<img width="983" height="587" alt="image" src="https://github.com/user-attachments/assets/d08a988f-dbdf-49be-9adc-941b97ebcd80" />

## 🧩 Penjelasan Code
### File: AndroidManifest.xml
File ini berfungsi untuk mendaftarkan komponen aplikasi Android (seperti Activity, Service, BroadcastReceiver, Provider) dan menentukan konfigurasi dasar aplikasi.
#### <img width="813" height="186" alt="image" src="https://github.com/user-attachments/assets/65306980-d0c1-4647-8be4-8dcc3d9b1245" />
- Baris pertama adalah deklarasi XML.
- <manifest> adalah root utama dari file.
- xmlns:android → namespace bawaan Android.
- xmlns:tools → namespace tambahan untuk keperluan konfigurasi build (opsional).
#### <img width="824" height="408" alt="image" src="https://github.com/user-attachments/assets/bbdd0970-e96a-4485-a9e1-49836290a86f" />
- <application> → Membungkus semua komponen aplikasi.
- android:allowBackup="true" → data aplikasi bisa di-backup otomatis.
- android:dataExtractionRules & android:fullBackupContent → mengatur aturan backup.
- android:icon="@drawable/logo_zaki" → ikon utama aplikasi (custom logo).
- android:label="@string/app_name" → nama aplikasi, diambil dari strings.xml.
- android:roundIcon → ikon bulat (untuk device yang butuh ikon round).
- android:supportsRtl="true" → mendukung layout Right-to-Left (untuk bahasa Arab/Ibrani).
- android:theme="@style/Theme.App4recycle" → tema utama aplikasi.
#### <img width="821" height="197" alt="image" src="https://github.com/user-attachments/assets/d82c9edb-97e9-4738-b39d-ba739adea2be" />
- Activity detail → digunakan untuk menampilkan halaman detail.
- android:exported="false" → tidak bisa dipanggil oleh aplikasi lain (hanya internal).
#### <img width="829" height="399" alt="image" src="https://github.com/user-attachments/assets/cdb624fa-67a9-4cd2-bd5b-af5bae06e4f3" />
- SplashActivity → activity pertama yang muncul saat aplikasi dibuka.
- android:exported="true" → bisa dipanggil sistem/launcher.
- <intent-filter> dengan MAIN + LAUNCHER → menandakan activity ini adalah titik awal aplikasi.
#### <img width="820" height="149" alt="image" src="https://github.com/user-attachments/assets/401d3f23-dc63-4dac-8d27-3485086ea5da" />
- MainActivity → activity utama yang berisi daftar/menu utama aplikasi.
- Tidak ada intent-filter karena dia tidak diluncurkan pertama, tapi dipanggil setelah SplashActivity.

### Book.kt
#### <img width="823" height="328" alt="image" src="https://github.com/user-attachments/assets/b1384721-feba-4803-9a97-86424dfd2ee7" />
- package com.example.app4recycle : Menunjukkan lokasi/nama paket tempat file ini berada. Tujuannya untuk mengelompokkan kode agar rapi dan mudah dikelola.
- data class Book : data class adalah kelas khusus di Kotlin yang digunakan untuk menyimpan data. Kelas ini otomatis menyediakan fungsi penting seperti: toString() → untuk menampilkan isi objek dalam bentuk string. equals() → untuk membandingkan dua objek apakah sama. hashCode() → digunakan saat menyimpan data dalam struktur data seperti HashMap atau HashSet. copy() → untuk menyalin objek dengan nilai berbeda.
- val title: String : Properti pertama, title (judul buku), bertipe String. val artinya nilainya tidak bisa diubah (immutable).
- val author: String : Properti kedua, author (penulis buku), juga bertipe String.
- val year: Int : Properti ketiga, year (tahun terbit buku), bertipe Int (angka/bilangan bulat).

### detail.kt
File ini adalah Activity di Android yang menampilkan detail sebuah Book (judul, author, tahun).
#### <img width="809" height="116" alt="image" src="https://github.com/user-attachments/assets/7eb0b420-43dc-4863-84b7-6bfb65affe4c" />
Menentukan package tempat file ini berada, yaitu com.example.app4_recycle.
#### <img width="812" height="295" alt="image" src="https://github.com/user-attachments/assets/731df215-a91e-4653-8efc-b412bc23c5ec" />
Import library yang digunakan:
- Bundle → untuk menyimpan data saat Activity dibuat.
- TextView → untuk menampilkan teks di layar.
- enableEdgeToEdge() → membuat tampilan aplikasi lebih modern dengan layout full screen.
- AppCompatActivity → class dasar untuk Activity modern di Android.
- ViewCompat & WindowInsetsCompat → mengatur padding agar tampilan menyesuaikan status bar/navigation bar.
#### <img width="808" height="158" alt="image" src="https://github.com/user-attachments/assets/fc79a663-81dc-48da-9d09-de7cb6b3f35d" />
- Membuat class Activity bernama detail yang mewarisi AppCompatActivity.
- Variabel tvTitle dideklarasikan dengan lateinit, artinya akan diinisialisasi nanti.
#### <img width="805" height="234" alt="image" src="https://github.com/user-attachments/assets/9150ca4b-982e-4856-8e1f-a383e32b3083" />
onCreate dijalankan saat Activity pertama kali dibuat.
- super.onCreate(savedInstanceState) → memanggil fungsi bawaan.
- enableEdgeToEdge() → mengaktifkan layout full screen.
- setContentView(R.layout.activity_detail2) → menghubungkan Activity dengan layout XML activity_detail2.xml.
#### <img width="962" height="324" alt="image" src="https://github.com/user-attachments/assets/36b717c9-f2f4-4d6d-a7f9-c03934e4111b" />
Mengatur padding otomatis agar tampilan tidak tertutup status bar/navigation bar.
- findViewById(R.id.main) → mengambil layout utama.
- systemBars → mendapatkan ukuran status bar & navigation bar.
- setPadding(...) → memberi ruang agar UI aman tampil.
#### <img width="817" height="183" alt="image" src="https://github.com/user-attachments/assets/66a492e2-d08d-4f48-8603-52a56951af36" />
enghubungkan variabel Kotlin dengan komponen TextView yang ada di layout activity_detail2.xml.
- tvTitledet → menampilkan judul buku.
- tvAuthordet → menampilkan nama penulis.
- tvYear → menampilkan tahun terbit.
#### <img width="807" height="193" alt="image" src="https://github.com/user-attachments/assets/7bfb84b3-59e6-424a-ac5d-f73e3bb514dd" />
Mengambil data yang dikirim dari Activity sebelumnya (MainActivity / adapter) menggunakan Intent.
- "judul" → string judul buku.
- "author" → string nama penulis.
- "year" → angka tahun (default = 0).
- .toString() → karena tvYear butuh teks, angka diubah jadi string.
#### <img width="802" height="185" alt="image" src="https://github.com/user-attachments/assets/a105bb63-ead0-41f5-9a2d-a850d4048901" />
Menampilkan data yang diterima ke dalam TextView. Jadi, saat Activity ini terbuka, user akan lihat judul, author, dan tahun buku.

### MainActivity.kt
File MainActivity.kt adalah activity utama dalam aplikasi app4_recycle, fungsinya:
- Menampilkan daftar buku dalam bentuk RecyclerView.
- Mengatur data buku menggunakan ArrayList.
- Menghubungkan data dengan tampilan melalui BookAdapter.
#### <img width="811" height="228" alt="image" src="https://github.com/user-attachments/assets/06fbb69d-333a-4da1-87b9-c2fa1c1e72bc" />
MainActivity mewarisi AppCompatActivity agar bisa jadi activity utama.
- recyclerView: Komponen tampilan untuk menampilkan list buku.
- bookAdapter: Adapter khusus untuk menghubungkan data bookList ke RecyclerView.
- bookList: ArrayList yang menyimpan data semua buku.
#### <img width="811" height="183" alt="image" src="https://github.com/user-attachments/assets/0aea9581-f6b0-401a-9be3-5428998a5e54" />
onCreate() dipanggil saat activity pertama kali dibuat. setContentView() menampilkan layout utama (activity_main.xml).
#### <img width="811" height="157" alt="image" src="https://github.com/user-attachments/assets/8f41d54b-b483-4502-842a-ec2095b56e40" />
- findViewById mencari komponen RecyclerView dari layout.
- LinearLayoutManager(this) membuat daftar ditampilkan vertikal (scroll ke bawah).
#### <img width="812" height="217" alt="image" src="https://github.com/user-attachments/assets/4bdec52d-a401-480b-aa8e-f0d4ec5eb631" />
Menambahkan data dummy (contoh) ke dalam bookList. Masing-masing item berupa object Book dengan title, author, dan year.
#### <img width="813" height="191" alt="image" src="https://github.com/user-attachments/assets/07c29d5d-b795-4dc7-9211-bebdb48f791e" />
- BookAdapter(this, bookList): Membuat adapter dengan context activity ini dan daftar buku.
- recyclerView.adapter = bookAdapter: Menghubungkan RecyclerView dengan adapter agar data tampil.

### SplashActivity
SplashActivity adalah activity awal yang akan ditampilkan ketika aplikasi pertama kali dijalankan. Isinya menampilkan halaman splash screen (biasanya logo atau animasi singkat), lalu setelah beberapa detik otomatis pindah ke MainActivity.
#### <img width="810" height="114" alt="image" src="https://github.com/user-attachments/assets/42982fe6-7a2b-4ab9-9051-0d0a09a65ad7" />
SplashActivity adalah kelas turunan dari AppCompatActivity yang digunakan untuk membuat halaman awal aplikasi.
#### <img width="819" height="178" alt="image" src="https://github.com/user-attachments/assets/83fb7aaf-333e-4801-9064-25abe2c380f2" />
- onCreate() dipanggil saat Activity pertama kali dibuat.
- setContentView(R.layout.activity_splash) menampilkan layout XML bernama activity_splash (biasanya berisi logo atau gambar aplikasi).
#### <img width="831" height="216" alt="image" src="https://github.com/user-attachments/assets/79c812bc-7565-4e60-8c5a-d2027b331d14" />
- Handler + postDelayed digunakan untuk menunda eksekusi kode.
- Looper.getMainLooper() memastikan kode dijalankan di thread utama Android (UI thread).
- Setelah 2000 milidetik (2 detik), kode di dalam postDelayed akan dijalankan: startActivity(new Intent(...)) → membuka MainActivity. finish() → menutup SplashActivity agar tidak bisa kembali ke halaman splash dengan tombol back.

### BookAdapter.kt
Kode ini adalah adapter untuk RecyclerView yang menampilkan daftar buku. Adapter berfungsi untuk:
- Menghubungkan data (list buku) dengan tampilan item di RecyclerView.
- Menentukan bagaimana data setiap buku ditampilkan (judul, penulis, tahun).
- Mengatur interaksi ketika item daftar ditekan (klik), misalnya menampilkan dialog konfirmasi sebelum masuk ke halaman detail.
#### <img width="1119" height="142" alt="image" src="https://github.com/user-attachments/assets/80234f6f-9858-4f3a-951d-7ea24f9d8753" />
- BookAdapter menerima context (lingkungan aplikasi) dan daftar buku (bookList).
- RecyclerView.Adapter dipakai agar data bisa ditampilkan dalam bentuk list.
#### <img width="1121" height="219" alt="image" src="https://github.com/user-attachments/assets/b70997f7-34a4-4788-a50d-0868c58835b6" />
- onCreateViewHolder() dipanggil saat RecyclerView butuh tampilan item baru.
- LayoutInflater dipakai untuk menghubungkan XML layout item (item_book.xml) dengan objek View.
- Hasilnya dikembalikan dalam bentuk BookViewHolder.
#### <img width="1124" height="249" alt="image" src="https://github.com/user-attachments/assets/329ee530-0b85-4cf4-adef-99ce0dbd1203" />
onBindViewHolder() mengisi data buku sesuai posisinya. Misalnya: book.title ditampilkan ke tvTitle.
#### <img width="1123" height="576" alt="image" src="https://github.com/user-attachments/assets/86e670fa-5a86-4da2-8afa-1163f7747fa3" />
Saat item diklik, muncul dialog konfirmasi. Jika pengguna pilih “Lihat”, maka:
- Dibuat Intent menuju activity detail.
- Data buku (judul, author, year) dikirim lewat putExtra().
- Activity detail akan menampilkan data tersebut.
#### <img width="1123" height="117" alt="image" src="https://github.com/user-attachments/assets/66de728f-3f1b-48a5-bdab-a495173872d4" />
Mengembalikan jumlah item = banyaknya buku dalam bookList.
#### <img width="1124" height="260" alt="image" src="https://github.com/user-attachments/assets/480ceae0-d46a-4ff7-9f3b-aa195332ca55" />
- BookViewHolder menyimpan referensi ke TextView dalam layout item_book.
- Supaya adapter bisa langsung akses tvTitle, tvAuthor, tvYear tanpa perlu cari ulang setiap kali.

### Layout
#### <img width="511" height="651" alt="image" src="https://github.com/user-attachments/assets/8d0b5278-5028-4193-ac59-12e6a360ad0d" />
Layout activity_detail2.xml ini menggunakan LinearLayout dengan orientasi vertikal dan posisi konten di tengah layar (gravity="center"). Di dalamnya terdapat sebuah ImageView berukuran 200x300dp untuk menampilkan gambar sampul buku dengan scaleType="centerCrop", diikuti tiga TextView yang masing-masing digunakan untuk menampilkan detail informasi buku, yaitu judul (tvTitledet) dengan ukuran teks 24sp tebal, nama penulis (tvAuthordet) dengan ukuran teks 18sp, serta tahun terbit (tvYear) dengan ukuran teks 16sp. Struktur ini dirancang sederhana dan rapi untuk menampilkan detail buku secara terpusat pada layar.
#### <img width="1240" height="301" alt="image" src="https://github.com/user-attachments/assets/673aa5b1-8bb0-48f3-92cc-7e5fb265efb6" />
Layout activity_main.xml ini menggunakan ConstraintLayout sebagai root container dengan ukuran penuh layar (match_parent), dan di dalamnya hanya terdapat satu komponen utama yaitu RecyclerView yang juga memenuhi seluruh lebar dan tinggi layar. RecyclerView ini berfungsi untuk menampilkan daftar data dalam bentuk list atau grid yang dapat di-scroll, sehingga layout ini dirancang sederhana sebagai tampilan utama aplikasi yang berfokus pada menampilkan koleksi item secara dinamis.
#### <img width="818" height="403" alt="image" src="https://github.com/user-attachments/assets/d74dc8d6-0e75-4e7f-9f7d-0d4e770fdebd" />
Layout activity_splash.xml menggunakan LinearLayout dengan orientasi vertikal, latar belakang berwarna teal (#008080), serta konten yang diposisikan di tengah layar (gravity="center"). Di dalamnya terdapat sebuah ImageView berukuran 200x200dp yang menampilkan gambar logo aplikasi (@drawable/logo_zaki) dengan deskripsi konten "Logo". Layout ini sederhana dan berfungsi sebagai tampilan awal (splash screen) yang biasanya muncul sesaat saat aplikasi dibuka untuk menampilkan identitas atau logo aplikasi sebelum masuk ke halaman utama.
#### <img width="955" height="771" alt="image" src="https://github.com/user-attachments/assets/020e6f2a-b53e-4b77-9cfe-4e2300ca44ac" />
#### <img width="773" height="548" alt="image" src="https://github.com/user-attachments/assets/7230e3a8-54af-410c-a575-8615a5d7047d" />
Layout item_book.xml menggunakan CardView dengan sudut membulat (cardCornerRadius="8dp") dan bayangan (cardElevation="4dp") untuk menampilkan setiap item buku secara rapi dan terpisah. Di dalamnya terdapat RelativeLayout yang memuat elemen-elemen informasi buku: sebuah ImageView di sisi kiri untuk menampilkan gambar sampul buku (imgBook), lalu di sebelah kanan gambar terdapat tiga TextView yang ditata secara vertikal, yaitu judul buku (tvTitle) dengan teks tebal dan ukuran lebih besar (18sp), nama penulis (tvAuthor) dengan ukuran teks 14sp, serta tahun terbit (tvYear) juga berukuran 14sp. Layout ini dirancang agar setiap buku dalam daftar (RecyclerView) memiliki tampilan ringkas, jelas, dan estetis dalam bentuk kartu.

## ✨ Hasil

## 📑 Kesimpulan
Dari hasil perancangan dan pembuatan aplikasi Aplikasi Daftar Buku Perpustakaan berbasis Android, dapat disimpulkan bahwa aplikasi ini berhasil mengintegrasikan fitur utama Android seperti Splash Screen, RecyclerView, Intent, Toast, dan Dialog Box yang membuat aplikasi lebih interaktif dan mudah digunakan. Laporan ini menjadi bukti proses pengembangan sekaligus sarana pembelajaran dalam memahami konsep dasar pemrograman Android, sehingga dapat bermanfaat bagi mahasiswa maupun pengembang pemula sebagai referensi dalam mengembangkan aplikasi serupa.

