# eTalente-Springboot-Junior-Developer-Assessment


JUNIOR
SOFTWARE
DEVELOPER
Assessment
2023v1
Enviro365 Investments is seeking to automate the withdrawal notice process for its
investors. The process currently makes use of PDF forms which investors must download,
complete, sign and send to the service area via e-mail. This is a time-consuming exercise
which requires the service team to re-capture the withdrawal details from the PDF form
into the line of business system and creates room for service team to make mistakes.
When volumes are high, this also results in a bad experience for the investors where some
of the withdrawals are processed late. Having an automated process will result in an
improved investor experience and time saved for the service area to focus on other
important areas of the business.
The automated process should allow investors to select a product they are withdrawing
from, capture the withdrawal amount, dates and banking details the money must be paid
into. Once the withdrawal notice is completed, investors should receive a notification that
shows them the balance before the withdrawal was made, the amount withdrawn and the
closing balance
SCENARIO
TASK
Retrieve investor information (personal, address and contact) along with a list of
products the investor has invested in. Each product must provide a product ID,
type (RETIREMENT/SAVINGS), name and the current balance.
Create a new WITHDRAWAL NOTICE for a selected product.
Download a statement of all notices created for a selected product as a csv file
with date range provided
Build a Spring Boot application that exposes a REST API for consumers to:
If PRODUCT is RETIREMENT, then the investor's age must be greater than 65,
If WITHDRAWAL AMOUNT is greater than current BALANCE, then a validation error
must be returned
The following validations must be applied on submission of a WITHDRAWAL NOTICE
via the API:
otherwise respond with a validation error.
Investors cannot withdraw an AMOUNT more than 90% of the current BALANCE
THINGSTONOTE
All code should be written in a package
com.enviro.assessment.grad001.yournameandsurname
From a technical perspective, as per commonly accepted best practice, each
record has a primary key called “id” that identifies it – this is a technical id, and
Please model and implement the interface in the way you consider to be the
best way from an Object Oriented perspective.
As we will be accessing a real database as part of this exercise, please
implement an in memory database (H2).
Your submission must be a Springboot application with a rest endpoints
1.
2.
3.
4.
5.
6.
Y O U M A Y U N D E R G O A S U B S E Q U E N T I N T E R V I E W R E G A R D I N G
Y O U R S O L U T I O N , S O P L E A S E B E P R E P A R E D T O D I S C U S S A N Y
D E S I G N D E C I S I O N S Y O U M A Y T A K E N / A S S U M E D . P E R H A P S
M A K E R E L E V A N T C O M M E N T S I N Y O U R C O D E T H A T W I L L G U I D E
Y O U R D I S C U S S I O N S L A T E R .
DEADLINE
Youhave5days tocomplete theAssessmentfromthedate youreceive it.
SUBMISSION
Please submit your githublinkofthe assessmentonwww.etalente.co.za
