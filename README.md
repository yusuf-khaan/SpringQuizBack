# SpringQuizBack

**Spring Boot Quiz Application**
**Overview**
The Spring Boot Quiz Application is a dynamic and interactive platform designed to facilitate the creation, management, and participation in quizzes. Built using Java and Spring Boot, this application provides a comprehensive solution for educational or recreational quizzes, ensuring a seamless user experience.

**Formatting**
Below are the payloads of representation of data when deserialized into Java Objects
**1. banaoQuiz JSON Payload**
_this payload as the name suggest is to create a quiz of particular category available in the database which is user oriented as to what he prefer like Java, Python , IBM Quiz questions or any as per the Database_
{
  "category": "Sample Category",
  "title": "Sample Title",
  "NumberOfQuestions": 10
}

**2. noOfQs JSON Payload**
_This payload is for fun to explore the datastructures I made, I have other controller where you can just pass the Integer Value as No. Of Questions you want, Its Wholly randomly created Quiz from database to maintain versatility_
{
  "numberOfQuestions": 5
}

**3. Questions JSON Payload**
_This payload defines the Database Structure where the data is stored_
{
  "id": 1,
  "category": "Sample Category",
  "difficultylevel": "Medium",
  "questiontitle": "Sample Question Title",
  "option1": "Option 1",
  "option2": "Option 2",
  "option3": "Option 3",
  "rightanswer": "Option 1"
}

**4. ScheduleNukeDBS JSON Payload**
_As the name suggest it schedules a nuke, just Kidding! This quiz schedules a quiz which your teach might have created before from Original database and want you to give this quiz, In my controller there is a option to Schedule Quiz as Schedule/NukeTime which creates a quiz on basis of category you want and which utilizes banaoQuiz Data Struct_
{
  "id": 1,
  "Title": "Sample Schedule Title",
  "questions": [
    {
      "id": 1,
      "category": "Sample Category",
      "difficultylevel": "Medium",
      "questiontitle": "Sample Question Title",
      "option1": "Option 1",
      "option2": "Option 2",
      "option3": "Option 3",
      "rightanswer": "Option 1"
    },
    {
      "id": 2,
      "category": "Another Category",
      "difficultylevel": "Hard",
      "questiontitle": "Another Question Title",
      "option1": "Option A",
      "option2": "Option B",
      "option3": "Option C",
      "rightanswer": "Option B"
    }
  ]
}

**Key Features**
Quiz Management: Easily create, update, and delete quizzes with a variety of question types.
Category-Based Quizzes: Organize quizzes into categories, allowing users to focus on specific topics or areas of interest.
Randomized Questions: Implemented logic to randomize the order of questions, enhancing the challenge and fairness of the quizzes.
CRUD Functionality: Comprehensive CRUD operations for managing quizzes, questions, and categories using Spring Data JPA.
Database Integration: Utilized PostgreSQL for efficient and reliable data storage, with smooth integration via Spring JPA.
API Testing: Extensively tested all API endpoints using Postman, ensuring the application’s reliability and robustness.
Technologies Used
Backend: Java, Spring Boot, Spring Data JPA, Spring Hibernate
Database: PostgreSQL
Testing: Postman
**How It Works**
Users can create quizzes, add questions to them, and assign categories to quizzes.
The application randomizes the order of questions when a quiz is taken, adding an element of unpredictability.
All quiz-related data is stored in a PostgreSQL database, with CRUD operations handled by Spring Data JPA.
The application is designed to be easily extensible, allowing for future enhancements like adding timed quizzes or user authentication.
