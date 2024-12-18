const plays = {
    "hamlet": {"name": "Hamlet", "type": "tragedy"},
    "aslike": {"name": "As You Like It", "type": "comedy"},
    "othello": {"name": "Othello", "type": "tragedy"}
};

const invoice = [
    {
        "customer": "BigCo",
        "performances": [
            {
                "playID": "hamlet",
                "audience": 55
            },
            {
                "playID": "aslike", // Fix: Corrected playID from "as-like" to "aslike"
                "audience": 35
            },
            {
                "playID": "othello",
                "audience": 40
            }
        ]
    }
];

function statement(invoice, plays) {
    let totalAmount = 0;
    let volumeCredits = 0;
    let result = `Statement for ${invoice[0].customer}\n`; // Access the first element of the invoice array
    const format = new Intl.NumberFormat("en-US", {
        style: "currency", 
        currency: "USD",
        minimumFractionDigits: 2
    }).format;

    // Fix: Accessing performances correctly from the first invoice object
    for (let perf of invoice[0].performances) { // invoice[0].performances instead of invoice.performances
        const play = plays[perf.playID];
        let thisAmount = 0; 

        switch (play.type) {
            case "tragedy":
                thisAmount = 40000;
                if (perf.audience > 30) {
                    thisAmount += 1000 * (perf.audience - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (perf.audience > 20) {
                    thisAmount += 10000 + 500 * (perf.audience - 20);
                }
                thisAmount += 300 * perf.audience;
                break;
            default:
                throw new Error(`unknown type: ${play.type}`);
        }

        // Add volume credits
        volumeCredits += Math.max(perf.audience - 30, 0);
        // Add extra credit for every ten comedy attendees
        if ("comedy" === play.type) volumeCredits += Math.floor(perf.audience / 5);
        
        // Print line for this order
        result += ` ${play.name}: ${format(thisAmount / 100)} (${perf.audience} seats)\n`;
        totalAmount += thisAmount;
    }

    result += `Amount owed is ${ format(totalAmount / 100) } \n`;
    result += `You earned ${ volumeCredits } credits\n`;
    return result;
}

console.log(statement(invoice, plays));


/*



function statement(invoice, plays) {
    let totalAmount = 0;
        let volumeCredits = 0;
        let result = Statement for ${invoice.customer}\n;
    const format = new Intl.NumberFormat("en-US",
            { style: "currency", currency: "USD",
            minimumFractionDigits: 2}).format;
    for (let perf of invoice.performances) {
        const play = plays[perf.playID];
        let thisAmount = 0; 


        switch (play.type) {
            case "tragedy":
                thisAmount = 40000;
                if (perf.audience > 30) {
                    thisAmount += 1000 * (perf.audience  - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (perf.audience > 20) {
                    thisAmount += 10000 + 500 * (perf.audience - 20);
                }
                thisAmount += 300 * perf.audience;
                break;
            default:
                throw new Error(unknown type: ${play.type});
        }

        // add volume credits
        volumeCredits += Math.max(perf.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy" === play.type) volumeCredits += Math.floor(perf.audience / 5);
        // print line for this order
        result +=  ${play.name}: ${format(thisAmount / 100)} (${perf.audience} seats)\n;
        totalAmount += thisAmount;
    }
    result += Amount owed is ${ format(totalAmount / 100) } \n;
    result += You earned ${ volumeCredits } credits\n;
    return result;
    }
    
statement(invoice, plays)
*/