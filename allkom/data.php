<?php


    require_once('koneksi.php');

    $query = "SELECT * FROM stok";
    $sql   = mysqli_query($db_connect, $query);
    
    $result = array();
    
    if ($sql) {
        $result = array();
        while($row = mysqli_fetch_array($sql)){
            array_push($result, array(
                'id' => $row['id'],
                'nama' => $row['nama'],
                'brand' => $row['brand'],
            ));
        }

        echo json_encode( array('allkom' => $result));
    }


?>
