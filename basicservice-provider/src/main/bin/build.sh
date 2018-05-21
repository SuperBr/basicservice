while getopts ":r:a:t:p:d:" opt
do
    case $opt in
        r)
        echo "参数rep的值$OPTARG"
        rep=$OPTARG
        ;;
        a)
        echo "参数appName的值$OPTARG"
         appName=$OPTARG
        ;;
        t)
        echo "参数tag的值$OPTARG"
        tag=$OPTARG
        ;;
        p)
            echo "参数push的值$OPTARG"
            push=$OPTARG
        ;;
         d)
         echo "参数port的值$OPTARG"
         port=$OPTARG
         ;;
    esac
done
echo "docker build  -t  $rep/$appName:$tag"
echo "docker push $rep/$appName:$tag"
echo "docker run  -i restart="alwasy" --name Zkconsole $rep/$appName:$tag"

docker stop $appName
docker rm   $appName
docker rmi   $rep/$appName:$tag

docker build  -t  $rep/$appName:$tag .

if [ $push = "true" ] ; then
echo "push start!!!"
docker push $rep/$appName:$tag
fi

docker run  -d  -p $port:9091 --name $appName $rep/$appName:$tag