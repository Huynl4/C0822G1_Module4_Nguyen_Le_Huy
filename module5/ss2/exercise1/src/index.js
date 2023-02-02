// // happy coding 👻
var num = 5;
// let n1: number = 0;
// let n2: number = 1;
// let temp: number = 0;
var sum = 0;
// @ts-ignore
function fn(num) {
    if (num <= 1) {
        return num;
    }
    return fn(num - 1) + fn(num - 2);
}
// let fibonacci = (num: number): number => {
//     if (num <= 1) {
//         return num;
//     }
//     return fibonacci(num - 1) + fibonacci(num - 2);
// }
document.write("Fibonacci: ");
for (var i = 0; i < num; i++) {
    document.write(String(fn(i)));
    sum += fn(i);
    document.writeln();
}
alert("Tổng: " + sum);
