# **Technical Test** 

## General Requirements: 

To complete this technical test, you are required to follow the following instructions: 

1. For UI automation (mobile), you are free to choose which platform you would like to automate, either android or ios or both of it. However, automating both platforms would be greatly appreciated. 

2. In creating UI automation (mobile), you are required to use Java programming language, cucumber framework, and implement POM (page object model) pattern. 

3. For API automation, you are required to use the Java programming language and implement the MVC (Model, View, Controller) pattern. 

4. Please do upload your answer for test automation code to Github repository (public access), and do create documentation setup to run your code in README.md 

5. Do record your test run, and attach the link in <u>README.md</u> 

6. For database query, you can submit it in a pdf file. 

7. Do submit your answer within 3 days since you received this test! 

8. Good luck! 

## A. Automation Test Case Study 

### **1. Mobile (Android / IOS)** 

- Do download & install this sample application for android or/and ios platform from this github repository: https://github.com/saucelabs/sample-app-mobile/releases 

- Explore the application, and create UI automation scenario to make a purchase for this products: 

   - Sauce Labs Backpack 

   - Sauce Labs Bike Light 

### **2. API** 

- Do visit & explore API documentation from this link https://fakerapi.it/ 

- Create automation script for endpoint /api/v2/persons with query param _quantity=10, _gender=male, _birthday_start=1990-01-01, and _birthday_end=2000-12-31 

- From the given endpoint, you should verify the following response data: - Verify the value of total data should return the expected amount **“10”** 

   - Verify each person’s gender should return the expected value **“male”** 

   - Verify each person’s birthday should return the value **between the given birthday_start, and birthday_end** 

#### 3. **BDD** 

Please download & install Alfagift app in play store or app store, try out & explore the app! Write 1 scenario from Alfagift use cases that you prefer with BDD principle and create UI automation tests (Android or IOS) from said scenario using Java Programming Language and Cucumber Framework! 

## B. Database Query 

Based on the following tables, do answer the following questions! 

1. Perform the query to display product_name, category_name, product_price, stock_availability, and provider_type for product containing name ' Sweaty Gold Popok’ and providerType ‘warehouse’. The product prices should be less than IDR 100,000 with stock_availability less than 10 and eod ‘2025-07-01’. 

2. What is the highest price for the product containing the name “Sweaty White Popok Celana” ? 

3. How to find out the product name with stock availability more than 10 using subquery? 

#### tb_master_product 

|product_id|sku_seller|product_name|product_price|category_id|
|---|---|---|---|---|
|12221|W000001|Sweaty White<br>Popok Celana L|99000.00|132|
|12222|W000011|Sweaty Gold<br>Popok Celana L|99000.00|132|
|12223|S000011|Sweaty White<br>Popok Celana XL|100000.00|132|
|12224|S002211|Sweaty Gold<br>Popok Celana<br>XXL|259000.00|132|
|12225|W002311|Sweaty White<br>Popok Celana M|92000.00|132|
|12226|W002691|Sweaty Gold<br>Popok Celana S|90000.00|132|



tb_master_product_category 

|category_Id|category_name|
|---|---|
|130|Makanan & Minuman|
|131|Kebutuhan Rumah Tangga|
|132|Kebutuhan Ibu & Anak|
|133|Kebutuhan Dapur|



tb_master_product_stock_availability 

|stock_id|sku_seller|stock_avai<br>lability|raw_stock|eod|provider_type_id|
|---|---|---|---|---|---|
|13001|W000001|9|10|2025-07-02|1|
|13002|W002691|8|6|2025-07-01|1|
|13221|S002211|10|11|2025-07-01|2|
|14222|S000011|20|22|2025-08-01|2|
|15222|W000011|6|10|2025-07-01|1|
|16222|W002311|15|16|2025-07-20|1|



#### tb_product_provider 

|provider_type_id|Provider_type_name|provider_status|
|---|---|---|
|1|warehouse|active|
|2|store|active|
|3|marketplace|active|



#### C. Mapper Data 

|Nos<br>Field Promo<br>Invoice|head|Kondisi|
|---|---|---|
|End Date|Tgl Akhir/ tgl<br>expired|(case when tgl_expired not null then (case when tgl_expired> tgl_akhir<br>then tgl_akhir else(tgl_expired - 1)end)else tgl_akhir end)|



"data": [{ 

"company": "ACB", "faktur": "T-G21-2077", "tgl_awal": "2021-07-16", "tgl_akhir": "2021-07-31", "tgl_rubah": "2021-07-13", "tgl_buat": "2021-07-13", "tgl_expired": "2021-07-22"}] 

1. Jika sysdate = 2021-07-19 dan json head B tersebut **di-** **_publish_** maka **End Date** adalah? 

#### <u>Data Mapping</u> 

|Nos<br>Field Promo Invoice|head|Kondisi|
|---|---|---|
|1<br>Min Purchase Amount|Min rp||
|2<br>Min Purchase Qty|Min qty||
|3<br>Max Sales|Max sales|**(case When (kelipatan = T) or (max_rp is not null) or (min_qty is null) or**<br>**(max_qty is null) or (max rp > min_rp) or (max_rp/min_rp > 1) or (min_rp <**<br>**max rp) then min_rp else max_rp/min_rp end)**|
|4<br>Max Purchase Qty|Max qty||
|5<br>Multiple Status|kelipatan||



Data JSON "min_qty": "", "max_qty": "", "min_rp": "3000", "max_rp": "12000", "kelipatan": "T", 

2. Jika dipublish data Json berikut, berapa nilai Max Sales? Jelaskan jawabannya? 

|Nos<br>Field Promo Invoice|head|Kondisi|
|---|---|---|
|1<br>Min Purchase Amount|Min rp||
|2<br>Min Purchase Qty|Min qty||
|3<br>Max Sales|Max sales|**(case When (status= T) then min_rp else max_rp/min_rp end)**|
|4<br>Max Purchase Qty|Max qty||
|5<br>Multiple Status|kelipatan||



3. Jika ingin membuat Max Sales menjadi 15000, settinglah max_rp dan status (T/F) yang harus diisi ? Data JSON yang harus di publish dengan param data json yang tidak boleh diubah adalah min_rp = 3000 

#### Data JSON 

"min_rp": "3000", "max_rp": "???", "kelipatan": "???", 

