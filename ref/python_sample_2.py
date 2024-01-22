def language_skills(speak_1: int, listen_1: int, read_1: int, write_1: int, all_2: str) -> int:
    """
    Calculates the total of points for the language skills regarding speaking, listening, reading, and writing.
    
    Args:
        speak_1 (int): The score for speaking skills.
        listen_1 (int): The score for listening skills.
        read_1 (int): The score for reading skills.
        write_1 (int): The score for writing skills.
        all_2 (str): The score for having all the skills.
    
    Returns:
        int: Total amount of points for language skills.
    """
    # Docstring format inspired by https://www.python-engineer.com/posts/vscode-python-setup/

    language_points = 0

    def check_points(points, skill):
        if skill >= 9:
            return points + 6
        elif skill >= 8:
            return points + 5
        elif skill >= 7:
            return points + 4
        return points

    language_points = check_points(language_points, speak_1)
    language_points = check_points(language_points, listen_1)
    language_points = check_points(language_points, read_1)
    language_points = check_points(language_points, write_1)

    language_points += 4 * (all_2 == "yes" and speak_1 >= 5 and listen_1 >= 5 and read_1 >= 5 and write_1 >= 5)
    
    return language_points

def education_level(education: str) -> int:
    """
    Assigns points for the education levels in response to the ones provided.

    Args:
        education (str): The score for education level.
    
    Returns:
        int: Considers the total amount of points for education level.
    """
    # Docstring format inspired by https://www.python-engineer.com/posts/vscode-python-setup/

    if education == 'Secondary school (high school diploma)':
        return 5
    elif education == 'One-year degree, diploma or certificate':
        return 15
    elif education == 'Two-year degree, diploma or certificate':
        return 19
    elif education == 'Bachelor\'s degree or other programs (three or more years)':
        return 21
    elif education == 'Two or more certificates, diplomas, or degrees':
        return 22
    
    elif education == 'Professional degree needed to practice in a licensed profession':
        return 23
    elif education == 'University degree at the Master\'s level':
        return 23
    elif education == 'University degree at the Doctoral (PhD) level':
        return 25
    else:
        return 0

def work_experience(experience: int) -> int:
    """
    Assigns points based on the applicant's work experience in response to the number of years in experience.

    Args:
        experience (int): Years of work experience.
    
    Returns:
        int: Total points for work experience.
    """
    # Docstring format inspired by https://www.python-engineer.com/posts/vscode-python-setup/

    if experience < 1:
        return 0
    elif experience == 1:
        return 9
    elif 2 <= experience <= 3:
        return 11
    elif 4 <= experience <= 5:
        return 13
    else:
        return 15

def calculate_age(age: int) -> int:
    """
    Assigns points depending on the applicant's age.

    Args:
        age (int): Applicant's age.
    
    Returns:
        int: Calculation of the total points for age.
    """
    # Docstring format inspired by https://www.python-engineer.com/posts/vscode-python-setup/

    if 18 <= age <= 35:
        return 12
    elif 36 <= age <= 47:
        return max(0, 12 - (age - 35))
    elif age >= 48:
        return 0
    else:
        return 0

def arranged_employment(arranged: str) -> int:
    """
    Assigns points regarding the applicant's arranged employment status.

    Args:
        arranged (str): Arranged employment status.
    
    Returns:
        int: Total arranged employment points.
    """
    # Docstring format inspired by https://www.python-engineer.com/posts/vscode-python-setup/

    if arranged == 'yes':
        return 10
    else:
        return 0

def adaptability(spouse_language: str, spouse_education: str, spouse_work: str, you_education: str, you_work: str, you_employment: str, relatives: str) -> int:
    """
    Calculates the total amount of points in response for the other considerations including some family members qualifications.

    Args:
        spouse_language (str): The score for spouse's language skills.
        spouse_education (str): The score for spouse's past studies.
        spouse_work (str): The score for spouse's work experience.
        you_education (str): The score for your past studies.
        you_work (str): The score for your past work.
        you_employment (str): The score for having arranged employment.
        relatives (str): The score for having relatives in Canada.
    
    Returns:
        int: Total amount of adaptability points.
    """
    # Docstring format inspired by https://www.python-engineer.com/posts/vscode-python-setup/

    adaptability_points = 0

    adaptability_points += 5 * (spouse_language == 'yes')
    adaptability_points += 5 * (spouse_education == 'yes')
    adaptability_points += 5 * (spouse_work == 'yes')
    adaptability_points += 5 * (you_education == 'yes')
    adaptability_points += 10 * (you_work == 'yes')
    adaptability_points += 5 * (you_employment == 'yes')
    adaptability_points += 5 * (relatives == 'yes')

    return min(adaptability_points, 10)

def main():
    """
    This main function prompts the user to input the two required files to calculate the applicant's points and 
    determine the amount of qualified applicants. Then it generates an output file inside the data -> output directory 
    provided with the qualified applicants.

    """

    infile = input("Please provide the name of the input file (to be located in data\\input\\): ").strip()
    outfile = input("Please provide the name of the output file (to be placed in data\\output\\): ").strip()
    qualified_applicants = []
    with open("data\\input\\" + infile, 'r') as infile:
        next(infile)
        for line in infile:
            columns = line.strip().split('\t')
            first_name = columns[0]
            last_name = columns[1]
            age_val = int(columns[2])
            speak_val = int(columns[4])
            listen_val = int(columns[5])
            read_val = int(columns[6])
            write_val = int(columns[7])
            all_2 = str(columns[8])
            edu_val = columns[9]
            exp_val = int(columns[10])
            arranged_val = columns[11]
            spouse_lang_val = columns[12]
            spouse_edu_val = columns[13]
            spouse_work_val = columns[14]
            you_edu_val = columns[15]
            you_work_val = columns[16]
            you_employment_val = columns[17]
            relatives_val = columns[18]

            total_points = (
                language_skills(speak_val, listen_val, read_val, write_val, all_2) +
                education_level(edu_val) +
                work_experience(exp_val) +
                calculate_age(age_val) +
                arranged_employment(arranged_val) +
                adaptability(spouse_lang_val, spouse_edu_val, spouse_work_val, you_edu_val, you_work_val, you_employment_val, relatives_val))
            
            if total_points >= 67:
                qualified_applicants.append(
                    [first_name, last_name, age_val, speak_val, listen_val, read_val, write_val,
                        edu_val, exp_val, arranged_val, spouse_lang_val, spouse_edu_val, spouse_work_val,
                        you_edu_val, you_work_val, you_employment_val, relatives_val, total_points])

    with open("data\\output\\" + outfile, 'w') as outfile:
        outfile.write("First Name|Last Name|Age|Speak|Listen|Read|Write|Education|"
                            "Exp|Arranged|Spouse Lang|Spouse Edu|Spouse Work|You Edu|You Work|You Employment|"
                            "Relatives|Total Points\n")
        outfile.write("--------------------+--------------------+-----+-----+------+------+-----+----------+---+---------+" "------------+------------+-----------+--------+---------+---------------+---------+--------------\n")
        for applicant in qualified_applicants:
            outfile.write(
                f"{applicant[0]:<20}|{applicant[1]:<20}|{applicant[2]:>5}|{applicant[3]:>4}|{applicant[4]:>6}|"
                f"{applicant[5]:>5}|{applicant[6]:>5}|{applicant[7]:<10}|{applicant[8]:>3}|{applicant[9]:>9}|"
                f"{applicant[10]:>12}|{applicant[11]:>12}|{applicant[12]:>11}|{applicant[13]:>8}|{applicant[14]:>9}|"
                f"{applicant[15]:>15}|{applicant[16]:>9}|{applicant[17]:>14}\n")

    print(f"\nThere were {len(qualified_applicants)} qualified applicants")

if __name__ == "__main__":
    main()