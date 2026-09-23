# Android Appium Cucumber Automation Project Setup

Bangun dan rapikan project automation Android ini dari awal secara bertahap, dengan repository berikut sebagai referensi utama:

https://github.com/knmukaffa/Swaglabs_Mobile_AndroidApps_Automation

## Tujuan

Membuat project automation Android menggunakan:

- Java
- Maven
- Appium
- Selenium
- Cucumber
- UiAutomator2
- Allure Report

Gunakan repository referensi sebagai acuan **struktur, naming, flow, dan gaya coding**, tetapi jangan copy API lama secara mentah. Modernisasi hanya bagian yang memang sudah outdated.

Project harus tetap **simple dan mudah dipahami oleh first learner**. Jangan membuat framework terlalu kompleks atau enterprise-style.

---

## Environment

Gunakan environment berikut:

- Java/JDK runtime: 21
- Maven: sudah terinstall global
- Android Emulator: tersedia
- Android SDK + ADB: tersedia
- Appium Server: 3.x
- Appium Android Driver: UiAutomator2
- Appium Java Client: 10.1.1
- Selenium: gunakan versi yang secara resmi kompatibel dengan Appium Java Client 10.1.1
- Cucumber: gunakan versi stabil yang sesuai dengan project
- Allure: gunakan untuk reporting

Java compiler/project boleh tetap menggunakan release 17 jika saat ini sudah menggunakan 17. Jangan mengubah compiler release ke 21 hanya karena runtime menggunakan Java 21.

---

## 1. Review Project Terlebih Dahulu

Sebelum mengubah file:

1. Review seluruh struktur project yang sekarang.
2. Identifikasi apakah project sudah berupa Maven project.
3. Periksa `pom.xml`.
4. Periksa source code, test, feature, runner, hooks, driver, page object, dan configuration yang sudah ada.
5. Pertahankan bagian yang masih valid.
6. Jangan menghapus file atau merombak struktur tanpa alasan.

Setelah memahami project, baru lakukan perubahan yang diperlukan.

---

## 2. Maven & Dependency

Pastikan `pom.xml` valid dan sederhana.

Dependency utama:

- Appium Java Client `10.1.1`
- Selenium versi yang kompatibel dengan Appium Java Client `10.1.1`
- Cucumber
- JUnit jika memang dibutuhkan oleh konfigurasi Cucumber
- Allure Cucumber integration

### Selenium

Sebelum menentukan versi Selenium:

1. Verifikasi compatibility matrix resmi Appium Java Client `10.1.1`.
2. Jangan hanya menggunakan Selenium terbaru.
3. Periksa dependency tree Maven.
4. Jika Maven menarik versi Selenium yang lebih baru secara transitive tetapi versi tersebut tidak tercantum pada compatibility matrix resmi Appium `10.1.1`, pin Selenium ke versi yang secara resmi kompatibel.
5. Pastikan module Selenium yang digunakan konsisten pada versi yang sama.

Jangan mengubah dependency lain yang tidak diperlukan.

Setelah selesai:

```bash
mvn dependency:tree