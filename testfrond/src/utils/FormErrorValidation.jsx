export function minChartErrorValidation(input) {
    const regex = /^([a-z0-9\ ]{5,})$/i;
  
    if (!input || input === "" || regex.test(input) === false) {
      return true;
    }
  
    return false;
  }

export function minLetterErrorValidation(input) {
    const regex = /^([a-z\ ]{5,})$/i;
  
    if (!input || input === "" || regex.test(input) === false) {
      return true;
    }
  
    return false;
}