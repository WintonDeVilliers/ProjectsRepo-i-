# Capstone 1
# Compulsory task

# Ask for input() from user product type ( User can choose "Investment" or "Bond")
# if user input() is "Investment"
# Ask integer input from user for
# 1.amount user will deposit 2. interest rate 3.number of years will invest

# Ask input() from user for interest type (User can choose "Simple" or Compound)
# if user input() is "Simple" use formula to calculate total A =P*(1+r*t)
# print out total amount with interest applied
# if user input() is "Compound" use formula to calculate total A = P* math.pow((1+r),t)
# print out total amount with interest applied

# if user input() is "Bond"
# Ask user for integer input() for
# 1.present value of house 2.Interest rate 3.number of months user plans to payback bond
# convert user interest rate to monthly (divide annual by 12)
# print out monthly repayment

import math

print("Choose either 'investment' or 'bond' from the menu below to proceed ")
print('\n')

print("investment  - to calculate the amount of interest you'll earn on interest")
print("bond        - to calculate the amount you'll have to pay on home loan")
print('\n')

print("Enter your selections below")
product_selection = input("Would you like to calculate an Investment or Bond? : ")

if product_selection == "investment" or product_selection == "Investment" or product_selection == "INVESTMENT":
    deposit = float(input("How much money would you like to deposit? : "))

    rate = float(input("What is the interest rate of the investment? : "))

    duration = float(input("For how many years would you like to invest your money?: "))

    print("Choose either 'Simple' or 'Compound' interest type from the menu below to proceed")
    print("\n")
    print('''Simple      -   interest is continually calculated on the initial amount invested,
                             known as the principal amount.
                         -   interest is calculated once a year.
                         -   the interest is added to your initial amount invested.''')

    print('''Compound    -   interest calculated on the initial principal,
                         -   which also includes all of the accumulated interest from previous periods
                         -   interest earnings are calculated once a year.''')
    print("\n")
    print("Enter your selection below")
    print("\n")
    interest_type = input("Which interest type would you like to select? ")

    if interest_type == "simple" or interest_type == "Simple" or interest_type == "SIMPLE":
        interest_earnings = deposit * (1 + (rate / 100) * duration)
        print("The total amount with interest applied will be ")
        print("R", round(interest_earnings, 2))

    elif interest_type == "compound" or interest_type == "Compound" or interest_type == "COMPOUND":
        interest_earnings = deposit * math.pow(1 + rate / 100, duration)
        print("The total amount with interest applied will be ")
        print("R", round(interest_earnings, 2))

if product_selection == "bond" or product_selection == "Bond" or product_selection == "BOND":
    home_value = float(input("What is the current value of the house you want to buy? : "))

    rate = float(input("What is the interest rate you would like to pay on the bond? : "))

    duration = float(input("For how many months would you like to pay off the bond ? : "))

    rate_monthly = (rate / 100) / 12

    monthly_bond_repayment = (rate_monthly * home_value) / (1 - (math.pow(1 + rate_monthly, -duration)))

    print("Your monthly repayment on the Bond would be :")
    print("R", round(monthly_bond_repayment, 2))
