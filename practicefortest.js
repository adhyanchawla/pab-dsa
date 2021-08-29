//max frequency

const arr = [1,2,3,1,2,3,4,5,1,1,1,2,2,3];
let count = 0;
let maxCount = 0;
let maxEle = 0;

for(let i = 0; i < arr.length; i++)
{
    count = 0;
    for(let j = i; j < arr.length; j++)
    {
        if(arr[j] == arr[i])
        {
            count++;
        }
    }
    if(count > maxCount)
    {
        maxCount = count;
        maxEle = arr[i];
    }
}

console.log(maxCount+ " " + maxEle);



let arrn = ['red','green','blue'];

let ans = '';

for(let i = 0; i < arrn.length; i++)
{
    ans += arrn[i];
}

console.log(ans);




