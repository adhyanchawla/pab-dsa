const fs = require("fs");
const cheerio = require("cheerio");
const request = require("request");

request("https://www.last.fm/music/+free-music-downloads", callback);

function callback(err,res,html)
{
    if(!err)
    {
        let $ = cheerio.load(html);
        let pages = "https://www.last.fm/music/+free-music-downloads?page=";
        //console.log("hello");
        //let pg = "?page=";
        for(let i = 1; i <= 1; i++)
        {
            request(pages + i, printLinks.bind(this, i));
        }
    }
}

let finalData = [];
function printLinks(idx,err,res,html)
{
    if(!err)
    {
        //fs.writeFileSync("song.html", html);
        let $ = cheerio.load(html);
        let songs = $(".chartlist-name")
        console.log(songs.length);
        // for(let i = 0; i < songs.length; i++)
        // {
        //     let name = $(songs[i])
        // }
    }
}