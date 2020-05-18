-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 08 Mei 2020 pada 16.16
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `posyandu`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bbu_l_a`
--

CREATE TABLE `bbu_l_a` (
  `umur_bln` int(10) NOT NULL,
  `kg3SDmin` double(10,1) NOT NULL,
  `kg2SDmin` double(10,1) NOT NULL,
  `kg1SDmin` double(10,1) NOT NULL,
  `median` double(10,1) NOT NULL,
  `kg1SDplus` double(10,1) NOT NULL,
  `kg2SDplus` double(10,1) NOT NULL,
  `kg3SDplus` double(10,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `bbu_l_a`
--

INSERT INTO `bbu_l_a` (`umur_bln`, `kg3SDmin`, `kg2SDmin`, `kg1SDmin`, `median`, `kg1SDplus`, `kg2SDplus`, `kg3SDplus`) VALUES
(0, 2.1, 2.5, 2.9, 3.3, 3.9, 4.4, 5.0),
(1, 2.9, 3.4, 3.9, 4.5, 5.1, 5.8, 6.6),
(2, 3.8, 4.3, 4.9, 5.6, 6.3, 7.1, 8.0),
(3, 4.4, 5.0, 5.7, 6.4, 7.2, 8.0, 9.0),
(4, 4.9, 5.6, 6.2, 7.0, 7.8, 8.7, 9.7),
(5, 5.3, 6.0, 6.7, 7.5, 8.4, 9.3, 10.4),
(6, 5.7, 6.4, 7.1, 7.9, 8.8, 9.8, 10.9),
(7, 5.9, 6.7, 7.4, 8.3, 9.2, 10.3, 11.4),
(8, 6.2, 6.9, 7.7, 8.6, 9.6, 10.7, 11.9),
(9, 6.4, 7.1, 8.0, 8.9, 9.9, 11.0, 12.3),
(10, 6.6, 7.4, 8.2, 9.2, 10.2, 11.4, 12.7),
(11, 6.8, 7.6, 8.4, 9.4, 10.5, 11.7, 13.0),
(12, 6.9, 7.7, 8.6, 9.6, 10.8, 12.0, 13.3),
(13, 7.1, 7.9, 8.8, 9.9, 11.0, 12.3, 13.7),
(14, 7.2, 8.1, 9.0, 10.1, 11.3, 12.6, 14.0),
(15, 7.4, 8.3, 9.2, 10.3, 11.5, 12.8, 14.3),
(16, 7.5, 8.4, 9.4, 10.5, 11.7, 13.1, 14.6),
(17, 7.7, 8.6, 9.6, 10.7, 12.0, 13.4, 14.9),
(18, 7.8, 8.8, 9.8, 10.9, 12.2, 13.7, 15.3),
(19, 8.0, 8.9, 10.0, 11.1, 12.5, 13.9, 15.6),
(20, 8.1, 9.1, 10.1, 11.3, 12.7, 14.2, 15.9),
(21, 8.2, 9.2, 10.3, 11.5, 12.9, 14.5, 16.2),
(22, 8.4, 9.4, 10.5, 11.8, 13.2, 14.7, 16.5),
(23, 8.5, 9.5, 10.7, 12.0, 13.4, 15.0, 16.8),
(24, 8.6, 9.7, 10.8, 12.2, 13.6, 15.3, 17.1),
(25, 8.8, 9.8, 11.0, 12.4, 13.9, 15.5, 17.5),
(26, 8.9, 10.0, 11.2, 12.5, 14.1, 15.8, 17.8),
(27, 9.0, 10.1, 11.3, 12.7, 14.3, 16.1, 18.1),
(28, 9.1, 10.2, 11.5, 12.9, 14.5, 16.3, 18.4),
(29, 9.2, 10.4, 11.7, 13.1, 14.8, 16.6, 18.7),
(30, 9.4, 10.5, 11.8, 13.3, 15.0, 16.9, 19.0),
(31, 9.5, 10.7, 12.0, 13.5, 15.2, 17.1, 19.3),
(32, 9.6, 10.8, 12.1, 13.7, 15.4, 17.4, 19.6),
(33, 9.7, 10.9, 12.3, 13.8, 15.6, 17.6, 19.9),
(34, 9.8, 11.0, 12.4, 14.0, 15.8, 17.8, 20.2),
(35, 9.9, 11.2, 12.6, 14.2, 16.0, 18.1, 20.4),
(36, 10.0, 11.3, 12.7, 14.3, 16.2, 18.3, 20.7),
(37, 10.1, 11.4, 12.9, 14.5, 16.4, 18.6, 21.0),
(38, 10.2, 11.5, 13.0, 14.7, 16.6, 18.8, 21.3),
(39, 10.3, 11.6, 13.1, 14.8, 16.8, 19.0, 21.6),
(40, 10.4, 11.8, 13.3, 15.0, 17.0, 19.3, 21.9),
(41, 10.5, 11.9, 13.4, 15.2, 17.2, 19.5, 22.1),
(42, 10.6, 12.0, 13.6, 15.3, 17.4, 19.7, 22.4),
(43, 10.7, 12.1, 13.7, 15.5, 17.6, 20.0, 22.7),
(44, 10.8, 12.2, 13.8, 15.7, 17.8, 20.2, 23.0),
(45, 10.9, 12.4, 14.0, 15.8, 18.0, 20.5, 23.3),
(46, 11.0, 12.5, 14.1, 16.0, 18.2, 20.7, 23.6),
(47, 11.1, 12.6, 14.3, 16.2, 18.4, 20.9, 23.9),
(48, 11.2, 12.7, 14.4, 16.3, 18.6, 21.2, 24.2),
(49, 11.3, 12.8, 14.5, 16.5, 18.8, 21.4, 24.5),
(50, 11.4, 12.9, 14.7, 16.7, 19.0, 21.7, 24.8),
(51, 11.5, 13.1, 14.8, 16.8, 19.2, 21.9, 25.1),
(52, 11.6, 13.2, 15.0, 17.0, 19.4, 22.2, 25.4),
(53, 11.7, 13.3, 15.1, 17.2, 19.6, 22.4, 25.7),
(54, 11.8, 13.4, 15.2, 17.3, 19.8, 22.7, 26.0),
(55, 11.9, 13.5, 15.4, 17.5, 20.0, 22.9, 26.3),
(56, 12.0, 13.6, 15.5, 17.7, 20.2, 23.2, 26.6),
(57, 12.1, 13.7, 15.6, 17.8, 20.4, 23.4, 26.9),
(58, 12.2, 13.8, 15.8, 18.0, 20.6, 23.7, 27.2),
(59, 12.3, 14.0, 15.9, 18.2, 20.8, 23.9, 27.6),
(60, 12.4, 14.1, 16.0, 18.3, 21.0, 24.2, 27.9);

-- --------------------------------------------------------

--
-- Struktur dari tabel `imunisasi`
--

CREATE TABLE `imunisasi` (
  `no_id` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `deskripsi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `imunisasi`
--

INSERT INTO `imunisasi` (`no_id`, `nama`, `deskripsi`) VALUES
('Id0001', 'Hepatitis B', 'Mencegah dari penularan hepatitis B dari orang lain di masa depannya, dan mencegah risiko penularan dari ibu ke anak saat persalinan. '),
('Id0002', 'Polio', 'Mencegah bayi mengidap kelumpuhan..'),
('Id0003', 'BCG', 'Mencegah adanya penyakit TBC'),
('Id0004', 'Campak', 'Mencegah penyakit campak '),
('Id0005', 'pentavalen (DPT-HB-HiB', 'Mencegah penyakit difteri, pertusis (batuk rejan), tetanus, hepatitis B, pneumonia, dan meningitis (radang otak)'),
('Id0006', 'MMR', 'Mencegah penyakit campak (Measles), gondongan (Mumps), dan Rubela (Campak Jerman.'),
('Id0007', 'tifoid', 'Mencegah infeksi bakteri Salmonella typhii yang merupakan penyakit tifus.'),
('Id0008', 'Rotavirus', 'Mencegah infeksi rotavirus yang bisa mengakibatkan diare kronis'),
('Id0009', 'PCV', 'Mencegah dari infeksi bakteri pneumokokus, yang menyebabkan penyakit pneumonia, meninghitis, dan infeksi telinga.'),
('Id0010', 'Varicella', 'Mencegah penyakit cacar air.'),
('Id0011', 'Influenza', 'Imunisasi anak yang dapat mencegah influenza berat.'),
('Id0012', 'Hepatitis A', 'Mencegah radang hati karena virus hepatitis A.'),
('Id0013', 'HPV (Human papiloma virus)', 'Melindungi tubuh dari virus HPV yang dapat mengakibatkan kanker serviks hingga kanke anus dan penis.');

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi`
--

CREATE TABLE `isi` (
  `nolayanan` varchar(20) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `idibu` varchar(30) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `berat_badan` varchar(10) NOT NULL,
  `usia_kehamilan` varchar(10) NOT NULL,
  `ukuran_fundus` varchar(10) NOT NULL,
  `tensi_darah` varchar(20) NOT NULL,
  `penyuluhan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `isi`
--

INSERT INTO `isi` (`nolayanan`, `tanggal`, `idibu`, `nama_lengkap`, `berat_badan`, `usia_kehamilan`, `ukuran_fundus`, `tensi_darah`, `penyuluhan`) VALUES
('IN0002', '2020-04-29', '001', 'siva', '', '', '', '', ''),
('IN0002', '2020-04-29', '001', 'siva', '', '', '', '', ''),
('IN0003', '2020-05-02', '3', 'w', '', '', '', '', ''),
('IN0005', '2020-05-02', '3', 'w', '321', '321', '321', '321', 'ffff'),
('IN0006', '2020-05-08', '3', 'w', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `isi_blt`
--

CREATE TABLE `isi_blt` (
  `notimbangan` varchar(20) NOT NULL,
  `tgl_timbang` varchar(20) NOT NULL,
  `idbalita` varchar(20) NOT NULL,
  `nama_balita` varchar(50) NOT NULL,
  `berat_badan` varchar(10) NOT NULL,
  `tinggi_badan` varchar(10) NOT NULL,
  `lingkar_kepala` varchar(10) NOT NULL,
  `zscore` varchar(10) NOT NULL,
  `status` varchar(100) NOT NULL,
  `imunisasi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelayanan_balita`
--

CREATE TABLE `pelayanan_balita` (
  `notimbangan` varchar(20) NOT NULL,
  `tgl_timbang` date NOT NULL,
  `berat_badan` double(10,2) NOT NULL,
  `tinggi_badan` double(10,2) NOT NULL,
  `lingkar_kepala` double(10,2) NOT NULL,
  `zscore` varchar(100) NOT NULL,
  `status` varchar(150) NOT NULL,
  `imunisasi` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `pelayanan_balita`
--

INSERT INTO `pelayanan_balita` (`notimbangan`, `tgl_timbang`, `berat_badan`, `tinggi_badan`, `lingkar_kepala`, `zscore`, `status`, `imunisasi`) VALUES
('IN0001', '2020-05-06', 9.00, 70.00, 10.00, '-2,43', 'Gizi Kurang', 'Item 1'),
('IN0002', '2020-05-06', 9.00, 80.00, 10.00, '-1,22', 'Gizi Baik', 'Item 1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelayanan_ibuhamil`
--

CREATE TABLE `pelayanan_ibuhamil` (
  `nolayanan` varchar(20) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `berat_badan` varchar(10) NOT NULL,
  `usia_kehamilan` varchar(10) NOT NULL,
  `ukuran_fundus` varchar(10) NOT NULL,
  `tensi_darah` varchar(20) NOT NULL,
  `penyuluhan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelayanan_ibuhamil`
--

INSERT INTO `pelayanan_ibuhamil` (`nolayanan`, `tanggal`, `berat_badan`, `usia_kehamilan`, `ukuran_fundus`, `tensi_darah`, `penyuluhan`) VALUES
('IN0001', '2020-04-29', '', '', '', '', ''),
('IN0002', '2020-04-29', '', '', '', '', ''),
('IN0003', '2020-05-02', '', '', '', '', ''),
('IN0004', '2020-05-02', '123', '123', '123', '123', 'asdasd'),
('IN0005', '2020-05-02', '321', '321', '321', '321', 'ffff'),
('IN0006', '2020-05-08', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendaftaran_balita`
--

CREATE TABLE `pendaftaran_balita` (
  `idbalita` varchar(10) NOT NULL,
  `nama_anak` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `nama_ayah` varchar(50) NOT NULL,
  `nama_ibu` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `Usia` varchar(20) NOT NULL,
  `berat_badan` varchar(10) NOT NULL,
  `panjang_badan` varchar(10) NOT NULL,
  `rt` varchar(10) NOT NULL,
  `rw` varchar(10) NOT NULL,
  `alamat_lengkap` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pendaftaran_balita`
--

INSERT INTO `pendaftaran_balita` (`idbalita`, `nama_anak`, `jenis_kelamin`, `nama_ayah`, `nama_ibu`, `tanggal_lahir`, `Usia`, `berat_badan`, `panjang_badan`, `rt`, `rw`, `alamat_lengkap`) VALUES
('001', 'Ade', 'Perempuan', 'Juned', 'Jenab', '2019-04-01', '1', '900', '80', '05', '05', 'Pekayon'),
('002', 'Kaka', 'Perempuan', 'Juned', 'Jenab', '2019-11-01', '1', '800', '90', '05', '05', 'Pekayon'),
('003', 'Kiki', 'Laki-Laki', 'Kaka', 'Keke', '2018-04-01', '2', '9000', '', '07', '08', 'Pekayon'),
('004', 'Lulu', 'Perempuan', 'Loki', 'Lala', '2018-03-01', '2', '15', '', '01', '01', 'Kalisari');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pendaftaran_ibuhamil`
--

CREATE TABLE `pendaftaran_ibuhamil` (
  `idibu` varchar(10) NOT NULL,
  `nama_lengkap` varchar(50) NOT NULL,
  `tanggal` varchar(30) NOT NULL,
  `bulan` varchar(20) NOT NULL,
  `tahun` varchar(10) NOT NULL,
  `usia` varchar(10) NOT NULL,
  `no_tlp` varchar(30) NOT NULL,
  `nama_suami` varchar(50) NOT NULL,
  `jumlah_balita` varchar(10) NOT NULL,
  `rt` varchar(10) NOT NULL,
  `rw` varchar(10) NOT NULL,
  `alamat_lengkap` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pendaftaran_ibuhamil`
--

INSERT INTO `pendaftaran_ibuhamil` (`idibu`, `nama_lengkap`, `tanggal`, `bulan`, `tahun`, `usia`, `no_tlp`, `nama_suami`, `jumlah_balita`, `rt`, `rw`, `alamat_lengkap`) VALUES
('3', 'w', '2', 'februari', '2016', '3', '3', 'e', '3', '3', '5', 'df');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `Id_petugas` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_tlp` varchar(20) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tugas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bbu_l_a`
--
ALTER TABLE `bbu_l_a`
  ADD PRIMARY KEY (`umur_bln`);

--
-- Indexes for table `pelayanan_balita`
--
ALTER TABLE `pelayanan_balita`
  ADD PRIMARY KEY (`notimbangan`);

--
-- Indexes for table `pendaftaran_balita`
--
ALTER TABLE `pendaftaran_balita`
  ADD PRIMARY KEY (`idbalita`);

--
-- Indexes for table `pendaftaran_ibuhamil`
--
ALTER TABLE `pendaftaran_ibuhamil`
  ADD PRIMARY KEY (`idibu`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`Id_petugas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
