# Compulsory Task 2

from datetime import date
today = (date.today())
status = "No"
#view_all = ""

add_file = open("tasks.txt", "a+")
user_file = open("user.txt", "r+")
login = False
border = "*" * 50
while login == False:

  username = input("Enter username: ")
  password = input("Enter password: ")

  for line in user_file:
        valid_user, valid_password = line.split(", ")

        if username == valid_user and password == valid_password:
            login = True

  if login == False:
      print("Incorrect details: Please enter a valid username and password")
  user_file.seek(0)

  if login == True:
      print(f"""
      {border}
      {border}
      Please select one of the following options:
      r -         register user
      a -         add task
      va -        view all tasks
      vm -        view my tasks
      e -         exit
      Admin Only(Only adminstrators can select below option)
      s -         Statistics
      {border}
      {border}""")
  menu_select = input("Enter your selection here --> :")
  if menu_select == "r":
     username = input("Confirm your username: ")
     password = input("Confirm your password: ")
     confirm_password = input("Please enter your password again")

     if password != confirm_password:
         print("Passwords do not match please retry")
         confirm_password = input("Enter your password again: ")
     elif password == confirm_password:
           combine = "\n"+ username +","+ '' ''+ confirm_password
           user_file.write(combine)

  if menu_select == "a":
      assigned_to = input("Who do you want to nominate for this task ? Enter Name:  ")
      task_name =  input("What is the name of the task")
      discription = input("Briefly discribe what the task entails: ")
      completion_date = input("Enter due date for completion for the task(eg. 1 April 1900): ")
      add_file.write(f"'\n'{assigned_to}, {task_name},{discription}, {today}, {completion_date}, {status}")
      #add_file.seek(0)


  if menu_select == "va":
    add_file = open("tasks.txt", "r")
    for line in add_file:
      assigned_to, task_name,discription, today, completion_date, status = line.split(", ")

      print(f"""
      Task assigned to : {assigned_to}
      Task name        : {task_name}
      Task Discription : {discription}
      Start date       : {today}
      Completion date  : {completion_date}
      Status           : {status}
      """)
    #add_file.close()

  if menu_select == "vm":
    add_file = open("tasks.txt", "r")
    for line in add_file:
      assigned_to, task_name,discription, today, completion_date, status = line.split(", ")
      if username == assigned_to:
        print(f"""
        Task assigned to : {assigned_to}
        Task name        : {task_name}
        Task Discription : {discription}
        Start date       : {today}
        Completion date  : {completion_date}
        Status           : {status}
        """)
      #  add_file.close()
  if menu_select == "s" and username == "admin" and password == "adm1n":
    user_file = open("user.txt", "r+")
    add_file = open("tasks.txt", "r+")
    for i in user_file:
      username, confirm_password = i.split(", ")
    for x in add_file:
      assigned_to, task_name,discription, today, completion_date, status = x.split(", ")
    print("Total number of users")
    print(len(i))
    print("Total number of tasks")
    print(len(x))

user_file.close()
add_file.close()
