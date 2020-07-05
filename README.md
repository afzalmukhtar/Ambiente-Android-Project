# Ambiente-Android-Project

## Abstract
With increasing rise of newer skin-care product in today’s market it has become difficult to choose which one is good for our skin and the environment too.
With the increase in the synthetic chemicals in different products, the harm that it can cause to our skin and the environment also increases.
**Our App is designed to rate the product according to it’s toxicity and also show each ingredient with its toxicity rating and give details of what harm it can cause in simple terms.**

## Existing System
* Few websites exist which provides data about toxicity of the ingredients and how harmful it is to the  skin
* These websites are either just focused on a particular set of companies or a particular area of function.
* They either provide detailed information on the ingredients, or provide an alternative, or have a small database on the products.
* These companies are mainly focused on products that are in the US markets.

## Our Proposal
* We’ve gathered data from multiple websites and government provided databases to make our own dataset.
* We have rated the products not just according to its harm to the skin but also how harmful it can be to the environment.
* The list of products and the ingredient concerns have been taken from a few reliable websites and the impact of each of these ingredients is taken from government provided data.

## Introduction
#### Our App is divided into 3 segments:
* The Category choice
* The Product choice
* The Product Information

**Category Choice:** Users choose from a range of various choices what they wish to look up for, like Creams, Eye Liners and so on.
**Product Choice:** Depending on what category a user has chosen, they will be provided with a list of products from which they can choose to look up for more detailed information on each ingredient.
**Product Information:** This provides information about every ingredient in the product and their rating and concerns related to them.

## Modules Used
* **AppCompatActivity:** This is a special library that allows working with the action bar features and activity features.
* **Fragment Manager:** This is needed to create and manage fragments.
* **Fragment Transaction:** This is needed to perform any adding, removing or replacing of fragments.
* **Linear Layout Manager:** This is used to get any features and function that can be performed on a Linear Layout.
* **Relative Layout Manager:** This is used to get any features and function that can be performed on a Relative Layout.
* **Bundle:** This is used to pass information as a bundle to different parts of the program, from activity to fragments and so on.
* **Log:** This is used to print any information in the logcat and mainly used for debugging.
* **Recycler View:** This is used instead of List View as this is much faster and less resource hungry.
* **Animation Utils:** This is to get the animation utilities to give transition and animation effects for different parts of the project.
* **ArrayLists:** This is used to store the collection of data retrieved from the Database.
* **Array:** Used for its functionality to convert a simple array to an ArrayList.
* **Intent:** To start new activities and control it.
* **LayoutInflater:** It is used to inflate(fill) a particular layout with the required data.
* **View:** To store the View Class object returned by the inflator.
* **ViewGroup:** To hold the parent View.
* **Context:** To store the context of the current activity
* **SQLiteDatabase:** To get the features of SQLite.
* **SQLiteOpenHelper:** It is a helper class for SQLite which allows to retrieve data from the Database with ease.
* **Cursor:** This is used to navigate through the databse.
* **Bitmap:** It is used to store a bitmap image.
* **BitmapFactory:** It is used to convert byte array retrieved from the database into a bitmap object.
* **SQLiteAssetHelper:** This is used to access externally created database from the assets folder.
* **RatingBar:** Used to store rating bar information and get access to the methods necessary to make changes to the rating bar dynamically.

## Team Detail
**Contributers:** 
* Afzal Mukhtar
* Hritika Rahul Mehta
* Abirami S.
