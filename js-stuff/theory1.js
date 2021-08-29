//decimaltobinary

function decimalToBinary(str)
{
    let ans = "";
    while(str > 0)
    {
        ans = str % 2 + ans;
        str = parseInt(str/2);
    }
    return ans;
}

console.log(decimalToBinary("10"));


//binarytodecimal
function binaryToDecimal(str)
{
    let sum = 0;
    let count = 0;

    while(str > 0)
    {
        let d = str % 10;
        sum += d * Math.pow(2, count); 
        count++;
        str = parseInt(str /10);
    }
    return sum;
}

console.log(binaryToDecimal("1010"));

//uppercase
// "adhyan chawla" --> "Adhyan Chawla"


function makeCapital(str)
{
    let ans = str.split(' ');
    for(let i = 0; i < ans.length; i++)
    {
        ans[i] = ans[i][0].toUpperCase() + ans[i].substring(1,);
    }
    return ans.join(' ');
}

console.log(makeCapital("adhyan chawla"));


//palindrome

function checkPalindrome(str)
{
    let i = 0;
    let j = str.length-1;
    while(i <= j)
    {
        if(str[i] != str[j])
        return false;

        i++;
        j--;
    }
    return true;
}


console.log(checkPalindrome("abba"));

//print Reverse "My name is Adhyan" --> "yM eman si nayhdA"
function reverseWord(str)
{
    let ans = str.split(' ');
    let ans1 = "";
    for(let i = 0; i < ans.length; i++)
    {
         for(let j = ans[i].length-1; j >= 0; j--)
         {
             ans1 += ans[i][j];
         }
         ans1 += " ";
    }
    return ans1;
}

console.log(reverseWord("My name is Adhyan"));


function mostFreq(str)
{
    const histogram = {};
    for(let i = 0; i < str.length; i++)
    {
        const ch = str[i];
        if(!histogram[ch])
        {
            histogram[ch] = 0;
        }
        histogram[ch]++;
    }
    let char;
    var keys = Object.keys(histogram);
    var max = histogram[keys[0]];

    for(var i = 1; i < keys.length; i++)
    {
        var val = histogram[keys[i]]; 
        if(max < val)
        {
            max = val;
        }
    }
    console.log("Maximum character " +  char +  ": " + "size: " + max + " ");
    console.log(histogram);
}


console.log(mostFreq("adfgashsfdagh"));



//first non - repeating character in string

function nonRepeat(str)
{
    let ans = str.split('');
    console.log(ans);
    let count = 0;
    let s = '';
    for(let i = 0; i < ans.length; i++)
    {
        s = ans[i];
        count = 0;
        for(let j = 0; j < ans.length; j++)
        {

            if(ans[i] === ans[j])
            {
                count++;
            }
        }

        if(count < 2)
        {
            break;
        }
    }
    return s;
}

console.log(nonRepeat("aaabbcdddeeef"));




























