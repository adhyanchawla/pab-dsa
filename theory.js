

// // let i = 0;

// // while(i < 10)
// // {
// //     console.log(i);
// //     i++;
// // }

// //let arr = [1, 2, 3, 4, 'hello', 'bye', true];

// // for(var i = 0; i < arr.length; i++)
// // {
// //     console.log(arr[i]);
// // }

// // arr.push('bansal');
// // console.log(arr);

// // const arr1 = new Array(10);
// // arr1[11] = 'hello';
// // arr1[2] = 'bye'
// // //mere andr change kr skte ho merko ni change kr skte...
// // console.log(arr1);

// // arr.pop();
// // console.log(arr);
// // arr[10] = 'hello';
// // console.log(arr);

// //max frequency
// let arr2 = [1,2,3,2,5,6,5,6,5,5,6,7,5,2,5,2,5,2,2,3,5,3,5,3,3,5,3,3];

// let count = 0;
// let maxCount = 0;
// let el = 0;
// for(let i = 0; i < arr2.length; i++)
// {
//     el = arr2[i];
//     count = 1;
//     for(let j = i+1; j < arr2.length; j++)
//     {
//         if(arr2[j] == el)
//         {
//             count++;
//         }
//     }
//     if(count > maxCount)
//     {
//         ans = arr2[i];
//         maxCount = count;
//     }
// }
// console.log(ans);
// console.log(maxCount);


// //sum of 2d array
// let arr = [[1,2,3], [4,5,6], [7,8,9]];
// let sum = 0;
// for(let i = 0; i < arr.length; i++)
// {
//     for(let j = 0; j < arr[i].length; j++)
//     {
//         sum += arr[i][j];
//     }
// }
// console.log(sum);


// //let arr = [[1,2,3], [4,5,6], [7,8,9]];
// // flattening
// let arr1 = [];

// let k = 0;
// for(let i = 0; i < arr.length; i++)
// {
//     for(let j = 0; j < arr[i].length; j++)
//     {
//         arr1.push(arr[i][j]);
//     }
// }

// console.log(arr1);


// // let arrn = ['red', 'green', 'white'];
// // let ans = '';
// // for(let i = 0; i < arrn.length; i++)
// // {
// //     ans += arrn[i];
// // }
// // console.log(ans);


// // let a = [1,2,3,4]
// // for(let i = 0; i < a.length; i++ )
// // {
// //     a[i] += 2;
// // }
// // console.log(a);


// // let a = [1,2,3,4];

// // function print(data, index)
// // {
// //     return data + 2;
// // }

// // a = a.map(print);
// // console.log(a);


// let a = [1,2,3,4,5,6,7,8];
// let a1 = [];
// for(let i = 0; i < a.length; i++)
// {
//     if(a[i] % 2 != 0)
//     {
//         a1.push(a[i]);
//     }
// }
// console.log(a1);

// //filter
// function removeEven(data, index)
// {
//     if(data % 2 == 0)
//     {
//         return true;
//     }
//     else return false;
// }

// a = a.filter(removeEven);

// console.log(a);

// let abc = '123';

// let x = 1;
// let y = 2;
// let z = 3;
// let str1 = `pepcoding${x + y + z}`

// let str2 = '"hello""world"';
// console.log(str1);

// console.log(abc[1])

// console.log(str2);


// for(let i = 0; i < str1.length; i++)
// {
//     console.log(str1[i]);
// }


// let a = 123
// let str = "hello";
// for(let i = a; i >= 0; i = parseInt(i / 2))
// {
//    // let ans = i % 2;
//     if(i % 2 == 0)
//     {
//         str += "" + (i % 2);
//     }
//     else{
//         str += "" + (i % 2);
//     }
// }

//console.log(str);


// let str = 'abcda';

// function isPalindrome(str)
// {
//     let i = 0;
//     let j = str.length-1;
//     //let count = 0;
//     console.log(str);
//     while(i <= j)
//     {
//         if(str[i] != str[j]){
//             return false;
//         }
//         i++;
//         j--;
//     }
//     return true;
// }




// console.log(isPalindrome(str));

//     let mySentence = "adhyan chawla";
//     let words = mySentence.split(" ");

//     for (let i = 0; i < words.length; i++) {
//         words[i] = words[i][0].toUpperCase() + words[i].substr(1);
//     }

//     str1 = "";

//     for(let i = 0; i < words.length; i++)
//     {
//         str1 += words[i] + " ";
//     }
//     console.log(str1);



    // let str = 'my name is adhyan'

    // let word = str.split(' ');
    // let ans = "";
    // for(let i = 0; i < word.length; i++)
    // {
    //     for(let j = word[i].length-1; j >= 0; j--)
    //     {
    //         ans += word[i][j];
    //     }
    //     ans += " ";
    // }
    // console.log(ans);



// let s = 'adfgashsfdagh';

// let l = s.split('');


// let count = 0;

// for(let i = 0; i < l.length; i++)
// {
//     if(s[i] == undefined)
//     {
//         count = 1;
//     }
//     else count++;
// }

let arr = [0,1,2,3,4];
let arr1 = ["A","B","C","D","E"];

let obj = {}

for(let i = 0; i < arr.length; i++)
{
    if(arr.length == 0 || arr1.length == 0 || arr.length > arr1.length || arr.length < arr1.length)
    {
        console.log("No solution");
    }
    else
    {
        obj[arr[i]] = arr1[i];
    }
}
console.log(obj);


const arr2 = [1,2,3,4,5,6];

[arr2[3], arr2[4]] = [arr2[4], arr2[3]];

console.log(arr2);

















