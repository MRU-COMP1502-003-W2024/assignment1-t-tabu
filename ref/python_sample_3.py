def language_level(speaking: int, listening: int, reading: int, writing: int, all_2: str) -> int:
    """ 
    Calculates the score for language skills
    Arguments will return a number based on the integer value
    """
    clb_level = [speaking, listening, reading, writing]
    total_points = 0       # Need this to add the total of all level components
    for level in clb_level:
        if level >= 9:
            total_points += 6
        elif level == 8:
            total_points += 5
        elif level == 7:
            total_points += 4
    if all_2 == "yes":
        total_points += 4
        
    return total_points
    
    
    
def education_level(level: str) -> int:
    """
    Calculates the score for education level
    Argument will return a number based on the string component
    """
    if level == "Secondary school (high school diploma)":
        return 5
    elif level == "One-year degree, diploma or certificate":
        return 15
    elif level == "Two-year degree, diploma or certificate":
        return 19
    elif level == "Bachelor's degree or other programs (three or more years)":
        return 21
    elif level == "Two or more certificates, diplomas, or degrees":
        return 22
    elif level == "Professional degree needed to practice in a licensed profession" or level == "University degree at the Master's level":
        return 23
    elif level == "University degree at the Doctoral (PhD) level":
        return 25
   
    
    
def work_level(experience: int) -> int:
    """
    Calculates the score for work experience
    Argument will return a number based on integer value
    """
    if experience >= 6:
        return 15
    elif experience >= 4:
        return 13
    elif experience >= 2:
        return 11
    elif experience == 1:
        return 9
    elif experience == 0:
        return 0
    return 0
    

def age_level(age: int):
    """
    Calculates the score for age
    Argument will return a number based on integer value
    """
    age_difference = 47 - age
    if age < 18 or age >= 47:
        return 0
    elif age <= 35:
        return 12
    elif age_difference >= 0:
        return age_difference
    
    

def arranged_employment_level(status: str) -> int:
    """
    Calculates the score for arranged employment
    Argument will return a number based on yes/no
    """
    if status == "yes":
        return 10
    else:
        return 0
        
        
def adaptability_level(spouse_language: str, spouse_studies: str, spouse_work: str,
                        your_studies: str, your_work: str, your_employment: str, relatives: str) -> int:
    """_summary_
    Calculates the score based on adaptability
    Arguments will return a number based on yes/no
    If number exceeds 10 break and return 10
    """
    calculate_adaptability = [spouse_language, spouse_studies, spouse_work,
                              your_studies, your_employment, relatives,]
    total_points = 0    # Need this to add the total of all adaptability components
    
    for line in calculate_adaptability:
        if line == 'yes':
            total_points += 5
            if total_points >= 10:
                break                   # need this to break if sum is over 10
    if your_work == 'yes':
        total_points += 10
    if total_points > 10:
        return 10                       

    
    return total_points
    
    
def calculated_scores(list_of_scores):
# Combines all criterias to find total score
    return sum(list_of_scores)
    
    
def main():
    # Input txt file to be found 
    dataset = input('Please provide the name of the input file (to be located in data/input): ')
    qualified = input('Please provide the name of the output file (to be placed in data/output): ')
    dataset_file = open(f'data/input/{dataset}', 'r')
    qualified_file = open(f'data/output/{qualified}', 'w')
    
    # Gets rid of header
    dataset_file.readline()    
    
    # Initialize array to store people
    people_list = []
    qualified_list = []         
    for person in dataset_file:
        #get rid of end space
        person = person.strip()
        #add each person to the list
        people_list.append(person)
    
    for people in people_list:

        people_data = people.split('\t')
        language_score = language_level(int(people_data[4]),        #speaking
                                        int(people_data[5]),        #listening
                                        int(people_data[6]),        #reading   
                                        int(people_data[7]),        #writing
                                        str(people_data[8]))        #all_2
        
        education_score = education_level(people_data[9])
        work_score = work_level(int(people_data[10]))
        age_score = age_level(int(people_data[2]))
        age_data = int(people_data[2])                  # need variable: age_data when putting information into output for qualified_applicants txt file
        arranged_employment_score = arranged_employment_level(str(people_data[11]))
        
        adaptability_score = adaptability_level(
                        str(people_data[12]),       #spouse_language
                        str(people_data[13]),       #spouse_studies
                        str(people_data[14]),       #spouse_work
                        str(people_data[15]),       #your_studies
                        str(people_data[16]),       #your_work          
                        str(people_data[17]),       #your_employment  
                        str(people_data[18]))       #relatives
        
        first_name = str(people_data[0])    # Need this for formatting qualified list
        last_name = str(people_data[1])
        
        list_of_scores = [language_score,
                          education_score,
                          work_score,
                          age_score,                        
                          arranged_employment_score,
                          adaptability_score]
        
        sum_of_lists = calculated_scores(list_of_scores)        

        
        if sum_of_lists >= 67:
            qualified_list.append(f"{first_name:20}{last_name:20}{age_data:5}{sum_of_lists:5}")
    print(f'There were {len(qualified_list)} qualified applicants')
            
    # Header needs to be outside the loop
    qualified_file.write('First Name\t\t\tLast Name\t\t\tAge|Score\n')
    qualified_file.write("--------------------+--------------------+-----+-----\n")
            
    for applicant in qualified_list:
        qualified_file.write(f'{applicant:20} \n')
            
    
        
    qualified_file.close()
    dataset_file.close()
    
 
main()




