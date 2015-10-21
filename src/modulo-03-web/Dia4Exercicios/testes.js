(function teste01(){
  console.assert('ovo'.isPalindrome()===true);
})();

(function teste02(){
  console.assert('ovos'.isPalindrome()===false);
})();
(function teste02(){
  console.assert(new Date(2000, 01, 01).bissexto()===true);
})();
(function teste02(){
  console.assert(new Date(2015, 01, 01).bissexto()===false);
})();
