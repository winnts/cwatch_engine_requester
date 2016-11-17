function formatDateString(dateString){
    return formattedDateString = dateString.getHours() + ":" + ("0"+dateString.getMinutes()).substr(-2)+ " "+dateString.getDate()+"/"+
                            (dateString.getMonth()+1)+"/"+dateString.getFullYear();
}