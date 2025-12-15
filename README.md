💱 Currency Converter
A Java console application that provides real-time currency conversion using live exchange rates from the ExchangeRate-API.

🚀 Features
Real-time exchange rates for USD, BRL, ARS, and COP

Bidirectional conversion between currencies

Clean console-based menu interface

Secure API key management using environment variables

📁 Project Structure
text
currency-converter/
├── src/main/java/
│   ├── Main.java                 # Application entry point and menu logic
│   ├── ExchangeRateService.java  # API communication and rate fetching
│   └── InvalidInputException.java # Custom exception for input validation
├── .env.example                  # Environment variable template
├── .gitignore                    # Git exclusion rules
└── pom.xml                       # Maven dependencies
⚙️ Setup Instructions
Prerequisites
Java 17 or higher

Maven (for dependency management)

ExchangeRate-API key (free from exchangerate-api.com)

Configuration
Clone the repository

Create a .env file in the project root:

text
EXCHANGE_RATE_API_KEY=your_api_key_here
Ensure .env is listed in .gitignore

Running the Application
bash
mvn compile exec:java -Dexec.mainClass="Main"
🔒 Security Note
API keys are never hardcoded. The application reads credentials from environment variables or .env files, keeping sensitive data out of version control.

📋 Supported Conversions
USD ↔ Brazilian Real (BRL)

USD ↔ Argentine Peso (ARS)

USD ↔ Colombian Peso (COP)

🛠️ Technologies
Java 17

ExchangeRate-API v6

Gson for JSON parsing

Maven for dependency management

📄 License
MIT License
